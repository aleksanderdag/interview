package org.example.DSA.Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    final Search OBJ = new Search();

    public static Stream<Arguments> checkIfExist() {
        return Stream.of(
                Arguments.of(new int[]{10,2,5,3}, true),
                Arguments.of(new int[]{3,1,7,11}, false),
                Arguments.of(new int[]{0,-2,2}, false),
                Arguments.of(new int[]{7,1,14,11}, true),
                Arguments.of(new int[]{2,2,14,19,19}, false),
                Arguments.of(new int[]{-16,-19}, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkIfExist(int[] nums, boolean expected) {
        assertEquals(expected, OBJ.checkIfExist(nums));
    }

    public static Stream<Arguments> validMountainArray() {
        return Stream.of(
                Arguments.of(new int[]{2,1}, false),
                Arguments.of(new int[]{3,5,5}, false),
                Arguments.of(new int[]{0,3,2,1}, true),
                Arguments.of(new int[]{0,2,3,4,5,2,1,0}, true),
                Arguments.of(new int[]{0,2,3,3,5,2,1,0}, false),
                Arguments.of(new int[]{0,3,2,1}, true),
                Arguments.of(new int[]{0,1,2,3,4,5,6,7,8,9}, false),
                Arguments.of(new int[]{9,8,7,6,5,4,3,2,1,0}, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void validMountainArray(int[] nums, boolean expected) {
        assertEquals(expected, OBJ.validMountainArray(nums));
    }
}