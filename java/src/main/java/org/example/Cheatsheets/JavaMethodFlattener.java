package org.example.Cheatsheets;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.utils.SourceRoot;

import java.nio.file.Path;
import java.util.*;

public class JavaMethodFlattener {

    public static void main(String[] args) throws Exception {
        Path sourceRootPath = Path.of("src/main/java");
        String className = "MyDualPointerSolver";
        String methodName = "solve";

        SourceRoot sourceRoot = new SourceRoot(sourceRootPath);
        CompilationUnit subCu = sourceRoot.parse("org/example/Cheatsheets", className + ".java");
        Optional<ClassOrInterfaceDeclaration> subclassOpt = subCu.getClassByName(className);
        if (subclassOpt.isEmpty()) {
            System.err.println("Class not found: " + className);
            return;
        }
        ClassOrInterfaceDeclaration subclass = subclassOpt.get();

        Map<String, MethodDeclaration> methodMap = new HashMap<>();
        for (MethodDeclaration method : subclass.getMethods()) {
            methodMap.put(method.getNameAsString(), method);
        }

        if (!subclass.getExtendedTypes().isEmpty()) {
            String superclassName = subclass.getExtendedTypes().get(0).getNameAsString();
            CompilationUnit superCu = sourceRoot.parse("org/example/Cheatsheets", superclassName + ".java");
            Optional<ClassOrInterfaceDeclaration> superclassOpt = superCu.getClassByName(superclassName);
            superclassOpt.ifPresent(superclass -> {
                for (MethodDeclaration method : superclass.getMethods()) {
                    methodMap.putIfAbsent(method.getNameAsString(), method);
                }
            });
        }

        flattenFromParsedMethodMap(methodMap, methodName);
    }

    public static void flattenFromParsedClass(ClassOrInterfaceDeclaration classDecl, String methodName) {
        Map<String, MethodDeclaration> methodMap = new HashMap<>();
        for (MethodDeclaration method : classDecl.getMethods()) {
            methodMap.put(method.getNameAsString(), method);
        }
        flattenFromParsedMethodMap(methodMap, methodName);
    }

    public static void flattenFromParsedMethodMap(Map<String, MethodDeclaration> methodMap, String methodName) {
        MethodDeclaration target = methodMap.get(methodName);
        if (target == null) {
            System.err.println("Method not found: " + methodName);
            return;
        }

        System.out.println("// Flattened method:");
        System.out.println("public " + target.getType() + " " + methodName + "(" + target.getParameters() + ") {");
        for (Statement s : flattenStatements(target, methodMap)) {
            System.out.println(s);
        }
        System.out.println("}");
    }

    private static List<Statement> flattenStatements(MethodDeclaration method, Map<String, MethodDeclaration> methodMap) {
        return flattenStatementsFromBlock(method.getBody().orElseThrow(), methodMap);
    }

    private static List<Statement> flattenStatementsFromBlock(BlockStmt block, Map<String, MethodDeclaration> methodMap) {
        List<Statement> flat = new ArrayList<>();
        JavaParser parser = new JavaParser();

        for (Statement s : block.getStatements()) {
            if (s.isExpressionStmt() && s.asExpressionStmt().getExpression().isVariableDeclarationExpr()) {
                VariableDeclarationExpr varDecl = s.asExpressionStmt().getExpression().asVariableDeclarationExpr();
                VariableDeclarator var = varDecl.getVariable(0);

                if (var.getInitializer().isPresent() && var.getInitializer().get().isMethodCallExpr()) {
                    MethodCallExpr call = var.getInitializer().get().asMethodCallExpr();
                    String methodName = call.getNameAsString();

                    if (methodMap.containsKey(methodName)) {
                        MethodDeclaration methodToInline = methodMap.get(methodName);
                        BlockStmt methodBody = methodToInline.getBody().orElseThrow().clone();

                        List<Parameter> params = methodToInline.getParameters();
                        List<Expression> args = call.getArguments();

                        for (int i = 0; i < params.size(); i++) {
                            String paramName = params.get(i).getNameAsString();
                            Expression argExpr = args.get(i);
                            methodBody.findAll(NameExpr.class).forEach(nameExpr -> {
                                if (nameExpr.getNameAsString().equals(paramName)) {
                                    nameExpr.replace(argExpr.clone());
                                }
                            });
                        }

                        // Add comment as a statement, not as a LineComment node
                        Statement commentStmt = parser.parseStatement("// inlined: " + methodName).getResult().orElseThrow();
                        flat.add(commentStmt);

                        for (Statement inlinedStmt : methodBody.getStatements()) {
                            if (inlinedStmt.isReturnStmt()) {
                                Expression retExpr = inlinedStmt.asReturnStmt().getExpression().orElse(new NullLiteralExpr());
                                Statement assignment = parser.parseStatement(var.getNameAsString() + " = " + retExpr + ";").getResult().orElseThrow();
                                flat.add(assignment);
                            } else {
                                flat.add(inlinedStmt);
                            }
                        }
                        continue;
                    }
                }
            }

            if (s.isBlockStmt()) {
                flat.addAll(flattenStatementsFromBlock(s.asBlockStmt(), methodMap));
            } else {
                flat.add(s);
            }
        }
        return flat;
    }
}
