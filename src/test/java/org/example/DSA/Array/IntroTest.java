package org.example.DSA.Array;

import org.example.DSA.SlidingWindow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntroTest {
    final Intro OBJ = new Intro();

    public static Stream<Arguments> findMaxConsecutiveOnes() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1, 1, 1}, 3),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource
    void findMaxConsecutiveOnes(int[] nums, int expected) {
        assertEquals(expected, OBJ.findMaxConsecutiveOnes(nums));
    }

    public static Stream<Arguments> findNumbers() {
        return Stream.of(
                Arguments.of(new int[]{12,345,2,6,7896}, 2),
                Arguments.of(new int[]{555,901,482,1771}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    void findNumbers(int[] nums, int expected) {
        assertEquals(expected, OBJ.findNumbers(nums));
    }

    public static Stream<Arguments> sortedSquares() {
        return Stream.of(
                Arguments.of(new int[]{-4,-1,0,3,10}, new int[]{0,1,9,16,100}),
                Arguments.of(new int[]{-7,-3,2,3,11}, new int[]{4,9,9,49,121}),
                Arguments.of(new int[]{-5,-3,-2,-1}, new int[]{1,4,9,25})
        );
    }

    @ParameterizedTest
    @MethodSource
    void sortedSquares(int[] nums, int[] expected) {
        assertArrayEquals(expected, OBJ.sortedSquares(nums));
    }
}
