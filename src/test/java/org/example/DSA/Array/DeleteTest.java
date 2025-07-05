package org.example.DSA.Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTest {
    final Delete OBJ = new Delete();

    public static Stream<Arguments> removeElement() {
        return Stream.of(
                Arguments.of(new int[]{3,2,2,3}, 3, new int[]{2,2}),
                Arguments.of(new int[]{0,1,2,2,3,0,4,2}, 2, new int[]{0,1,4,0,3})
        );
    }

    @ParameterizedTest
    @MethodSource
    void removeElement(int[] nums, int val, int[] expectedNums) {
        int k = OBJ.removeElement(nums, val); // Calls your implementation

        assertEquals(expectedNums.length, k);
        sort(nums, 0, k); // Sort the first k elements of nums
        sort(expectedNums, 0, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    public static Stream<Arguments> removeDuplicates() {
        return Stream.of(
                Arguments.of(new int[]{1,1,2}, new int[]{1,2}),
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, new int[]{0,1,2,3,4})
        );
    }

    @ParameterizedTest
    @MethodSource
    void removeDuplicates(int[] nums, int[] expectedNums) {
        int k = OBJ.removeDuplicates(nums); // Calls your implementation

        assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }
}
