package org.example.DSA.Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InsertTest {
    final Insert OBJ = new Insert();

    public static Stream<Arguments> duplicateZeros() {
        return Stream.of(
                Arguments.of(new int[]{1,0,2,3,0,4,5,0}, new int[]{1,0,0,2,3,0,0,4}),
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,3}),
                Arguments.of(new int[]{0,0,0,0,0,0,0}, new int[]{0,0,0,0,0,0,0})
        );
    }

    @ParameterizedTest
    @MethodSource
    void duplicateZeros(int[] arr, int[] expected) {
        OBJ.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    public static Stream<Arguments> merge() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3,  new int[]{1,2,2,3,5,6}),
                Arguments.of(new int[]{1}, 1, new int[]{}, 0,  new int[]{1}),
                Arguments.of(new int[]{0}, 0, new int[]{1}, 1,  new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource
    void merge(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        OBJ.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
}