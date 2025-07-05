package org.example.DSA.Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConclusionTest {
    Conclusion OBJ = new Conclusion();

    public static Stream<Arguments> heightChecker() {
        return Stream.of(
                Arguments.of(new int[]{1,1,4,2,1,3}, 3),
                Arguments.of(new int[]{5,1,2,3,4}, 5),
                Arguments.of(new int[]{1,2,3,4,5}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void heightChecker(int[] arr, int expected) {
        assertEquals(expected, OBJ.heightChecker(arr));
    }
}