package org.example.DSA.Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class D1Test {
    final D1 OBJ = new D1();

    public static Stream<Arguments> pivotIndex() {
        return Stream.of(
                Arguments.of(new int[]{1,7,3,6,5,6}, 3),
                Arguments.of(new int[]{1,2,3}, -1),
                Arguments.of(new int[]{2,1,-1}, 0),
                Arguments.of(new int[]{-1,-1,-1,1,1,1}, -1),
                Arguments.of(new int[]{2,3,-1,8,4}, 3),
                Arguments.of(new int[]{1,-1,4}, 2),
                Arguments.of(new int[]{2,5}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource
    void pivotIndex(int[] nums, int expected) {
        assertEquals(expected, OBJ.pivotIndex(nums));
    }

    public static Stream<Arguments> dominantIndex() {
        return Stream.of(
                Arguments.of(new int[]{3,6,1,0}, 1),
                Arguments.of(new int[]{1,2,3,4}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource
    void dominantIndex(int[] nums, int expected) {
        assertEquals(expected, OBJ.dominantIndex(nums));
    }

    public static Stream<Arguments> plusOne() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,4}),
                Arguments.of(new int[]{4,3,2,1}, new int[]{4,3,2,2}),
                Arguments.of(new int[]{9}, new int[]{1,0})
        );
    }

    @ParameterizedTest
    @MethodSource
    void plusOne(int[] digits, int[] expected) {
        assertArrayEquals(expected, OBJ.plusOne(digits));
    }
}