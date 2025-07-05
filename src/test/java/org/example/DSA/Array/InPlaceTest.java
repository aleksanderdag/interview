package org.example.DSA.Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InPlaceTest {
    final InPlace OBJ = new InPlace();

    public static Stream<Arguments> squareEven() {
        return Stream.of(
                Arguments.of(new int[]{9, -2, -9, 11, 56, -12, -3}, new int[]{81, -2, 81, 11, 3136, -12, 9})
        );
    }

    @ParameterizedTest
    @MethodSource
    void squareEven(int[] arr, int[] expected) {
        assertArrayEquals(expected, OBJ.squareEven(arr, arr.length));
    }

    public static Stream<Arguments> replaceElements() {
        return Stream.of(
                Arguments.of(new int[]{17,18,5,4,6,1}, new int[]{18,6,6,6,1,-1}),
                Arguments.of(new int[]{400}, new int[]{-1})
        );
    }

    @ParameterizedTest
    @MethodSource
    void replaceElements(int[] arr, int[] expected) {
        assertArrayEquals(expected, OBJ.replaceElements(arr));
    }

    public static Stream<Arguments> moveZeroes() {
        return Stream.of(
                Arguments.of(new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0}),
                Arguments.of(new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource
    void moveZeroes(int[] arr, int[] expected) {
        OBJ.moveZeroes(arr);
        assertArrayEquals(expected, arr);
    }

    private boolean hasSameElements(int[] arr1, int[] arr2) {
        Map<Integer, Integer> multiset1 = new HashMap<>();
        for (int x : arr1) multiset1.put(x, multiset1.getOrDefault(x, 0) + 1);
        Map<Integer, Integer> multiset2 = new HashMap<>();
        for (int x : arr2) multiset2.put(x, multiset2.getOrDefault(x, 0) + 1);

        return multiset1.equals(multiset2);
    }

    public static Stream<Arguments> sortArrayByParity() {
        return Stream.of(
                Arguments.of(new int[]{3,1,2,4}, new int[]{2,4,3,1}),
                Arguments.of(new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource
    void sortArrayByParity(int[] arr, int[] expected) {
        var output = OBJ.sortArrayByParity(arr);
        assertTrue(hasSameElements(output, arr));

        int i = 0;
        for (; i < output.length && output[i]%2 == 0; i++);
        for (; i < output.length; i++) assertTrue(output[i] % 2 != 0);

//        assertArrayEquals(expected, OBJ.sortArrayByParity(arr));
    }
}
