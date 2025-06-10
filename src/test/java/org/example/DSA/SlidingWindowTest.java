package org.example.DSA;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowTest {
    final SlidingWindow OBJ = new SlidingWindow();

    public static Stream<Arguments> provideArraysAndSums() {
        var nums = new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5};
        return Stream.of(
                Arguments.of(nums, 8, 4),
                Arguments.of(nums, 2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysAndSums")
    void findLength(int[] nums, int k, int length) {
        assertEquals(length, OBJ.findLength(nums, k));
    }

    @ParameterizedTest
    @CsvSource({"'1101100111', 5", "'1111101111', 10"})
    void testFindLengthOfOnes(String binary, int length) {
        assertEquals(length, OBJ.findLength(binary));
    }

    public static Stream<Arguments> numSubarrayProductLessThanK() {
        return Stream.of(
                Arguments.of(new int[]{10, 5, 2, 6}, 100, 8),
                Arguments.of(new int[]{10, 5, 2, 6, 1}, 100, 12)
        );
    }

    @ParameterizedTest
    @MethodSource
    void numSubarrayProductLessThanK(int[] nums, int k, int length) {
        assertEquals(length, OBJ.numSubarrayProductLessThanK(nums, k));
    }

    @Test
    void findBestSubarray() {
        assertEquals(18, OBJ.findBestSubarray(new int[]{3, -1, 4, 12, -8, 5, 6}, 4));
    }
}
