package org.example.DS.Concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;
import java.util.stream.Stream;

import static java.io.IO.print;
import static org.junit.jupiter.api.Assertions.*;

class FooTest {
    static Foo OBJ = new Foo();

    public static Stream<Arguments> first() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, "firstsecondthird"),
                Arguments.of(new int[]{1,3,2}, "firstsecondthird"),
                Arguments.of(new int[]{2,3,1}, "firstsecondthird"),
                Arguments.of(new int[]{2,3,1}, "firstsecondthird"),
                Arguments.of(new int[]{3,1,2}, "firstsecondthird")
        );
    }

    @ParameterizedTest
    @MethodSource
    void first(int[] indexes, String expected) throws InterruptedException {
        var threads = new Thread[indexes.length];
        for (int n = 0; n < 20; n++) {
            var out = new ByteArrayOutputStream();
            OBJ.out = new PrintStream(out);
            threads[0] = new Thread(() -> {
                try {
                    OBJ.first();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        threads[1] = new Thread(() -> {
            try {
                OBJ.second();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        threads[2] = new Thread(() -> {
            try {
                OBJ.third();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        for ( var i : indexes ) threads[i-1].start();
        for ( var thread : threads ) thread.join();
        System.out.println(out.toString().trim());
        assertEquals(out.toString().trim(), "firstsecondthird");
        }
    }
}