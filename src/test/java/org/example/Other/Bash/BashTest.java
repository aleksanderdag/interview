package org.example.Other.Bash;

import org.example.DB.TextFile;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BashTest {

    public static Stream<Arguments> line10() {
        return Stream.of(
                Arguments.of(new TextFile(
                                "file.txt", """
                                Line 1
                                Line 2
                                Line 3
                                Line 4
                                Line 5
                                Line 6
                                Line 7
                                Line 8
                                Line 9
                                Line 10
                                """), """
                        Line 10
                        """
                ),
                Arguments.of(new TextFile(
                                "file.txt", """
                                Line 1
                                Line 2
                                Line 3
                                Line 4
                                Line 5
                                Line 6
                                Line 7
                                Line 8
                                Line 9
                                """), """
                        
                        """
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    public void line10(TextFile file, String expected) throws IOException, InterruptedException {
        var script = new File("scripts/line10/line10.sh");
        var dir = script.getParentFile();
        var myFile = new File(dir, file.name());
        Files.writeString(myFile.toPath(), file.content(), StandardCharsets.UTF_8);
        var pb = new ProcessBuilder(script.getAbsolutePath());
        pb.redirectErrorStream(true);
        pb.directory(dir);
        var process = pb.start();
        var actual = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
//        var reader = new BufferedReader(new InputStreamReader());
//        String line;
//        var sb = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            sb.append(line).append("\n");
//        }
        assertEquals(expected, actual);
        process.waitFor();
    }

    public static Stream<Arguments> phoneNumbers() {
        return Stream.of(
                Arguments.of(
                        new TextFile("file.txt", """
                                987-123-4567
                                123 456 7890
                                (123) 456-7890
                                """), """
                        987-123-4567
                        (123) 456-7890
                        """
                ),
                Arguments.of(
                        new TextFile("file.txt", """
                                0(001) 345-0000
                                """), """
                        """
                ),
                Arguments.of(
                        new TextFile("file.txt", """
                                (001) 345-0000
                                """), """
                        (001) 345-0000
                        """
                ),
                Arguments.of(
                        new TextFile("file.txt", """
                                (001) 345-00001
                                """), """
                        """
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    public void phoneNumbers(TextFile file, String expected) throws IOException, InterruptedException {
        var script = new File("scripts/phoneNumbers.sh");
        var dir = script.getParentFile();
        var myFile = new File(dir, file.name());
        Files.writeString(myFile.toPath(), file.content(), StandardCharsets.UTF_8);
        var pb = new ProcessBuilder(script.getAbsolutePath());
        pb.redirectErrorStream(true);
        pb.directory(dir);
        var process = pb.start();
        var actual = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        assertEquals(expected, actual);
        process.waitFor();
    }

    public static Stream<Arguments> transpose() {
        return Stream.of(
                Arguments.of(
                        new TextFile("file.txt", """
                                name age
                                alice 21
                                ryan 30
                                """), """
                        name alice ryan
                        age 21 30
                        """
                )
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource
    public void transpose(TextFile file, String expected) throws IOException, InterruptedException {
        var script = new File("scripts/transpose/transpose.sh");
        var dir = script.getParentFile();
        var myFile = new File(dir, file.name());
        Files.writeString(myFile.toPath(), file.content(), StandardCharsets.UTF_8);
        var pb = new ProcessBuilder(script.getAbsolutePath());
        pb.redirectErrorStream(true);
        pb.directory(dir);
        var process = pb.start();
        var actual = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        assertEquals(expected, actual);
        process.waitFor();
    }
}
