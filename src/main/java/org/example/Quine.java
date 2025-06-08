package org.example;

public class Quine {
    public static void main(String[] args) {
        String quote = String.valueOf('"');
        char newLine = 10;
        String source = """
package org.example;

public class Quine {
    public static void main(String[] args) {
        String quote = String.valueOf('"');
        char newLine = 10;
        String source = ""%s"";
        System.out.printf(source, quote + newLine + source + quote);
    }
}
""";
        System.out.printf(source, quote + newLine + source + quote);
    }
}