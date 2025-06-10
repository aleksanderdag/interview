package org.example.DSA;

import com.github.javaparser.utils.SourceRoot;
import org.example.Cheatsheets.JavaMethodFlattener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Working directory: " + System.getProperty("user.dir"));
//        var sourceString = "src/main/java";
//        var sourceRoot = new SourceRoot(Paths.get(sourceString));
//        new PalindromeSolver().solve();
//        JavaMethodFlattener.flattenFromClass(Path.of("src/main/java/org/example/DSA"), PalindromeSolver.class, "solve");
//        JavaMethodFlattener.flattenFromClass(
//                Path.of("src/main/java"),
//                PalindromeSolver.class,
//                "solve"
//        );
        Path sourceRoot = Path.of("src/main/java");
        Class<?> clazz = PalindromeSolver.class;  // your concrete class
        String methodName = "solve";              // method to flatten

        // Save the original System.out so you can restore it later
        PrintStream originalOut = System.out;

        try (FileOutputStream fos = new FileOutputStream(sourceRoot + "/output.java");
             PrintStream fileOut = new PrintStream(fos)) {
            // Redirect System.out to file
            System.setOut(fileOut);

            // Now all System.out.println calls go to output.txt
//            System.out.println("This goes into the file!");
//            System.out.println("Another line in the file.");
//            flattenFromClassRecursive(sourceRoot, clazz, methodName);

        } finally {
            // Restore the original System.out
            System.setOut(originalOut);
        }

        // This prints back to the console
        System.out.println("This prints to console again.");
//        flattenFromClassRecursive(sourceRoot, "PalindromeSolver", "solve");
    }
}
