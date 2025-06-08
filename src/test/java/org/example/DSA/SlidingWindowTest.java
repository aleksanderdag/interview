package org.example.DSA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowTest {
    final SlidingWindow OBJ = new SlidingWindow();

    @Test
    void findLength() {
        assertEquals(4, OBJ.findLength(new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5},8));
        assertEquals(2, OBJ.findLength(new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5},2));
    }

    @Test
    void testFindLengthOfOnes() {
        assertEquals(5, OBJ.findLength("1101100111"));
        assertEquals(10, OBJ.findLength("1111101111"));
    }

    @Test
    void numSubarrayProductLessThanK() {
        assertEquals(8, OBJ.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        assertEquals(12, OBJ.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6, 1}, 100));
    }

    @Test
    void findBestSubarray() {
        assertEquals(18, OBJ.findBestSubarray(new int[]{3, -1, 4, 12, -8, 5, 6}, 4));
    }
}
