package org.example.DSA;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoPointersTest {

    final TwoPointers OBJ = new TwoPointers();

    @ParameterizedTest
    @CsvSource({"abcdcba, true", "racecar, true", "palindrome, false"})
    void checkIfPalindromeTest(String s, boolean isPalindrome) {
        assertEquals(isPalindrome, OBJ.checkIfPalindrome(s));
    }

    public static Stream<Arguments> checkForTargetTest() {
        return Stream.of(
                Arguments.of(new int[]{1,2,4,6,8,9,14,15}, 13, true),
                Arguments.of(new int[]{3, 6, 21, 23, 25}, 27, true),
                Arguments.of(new int[]{1, 2, 4, 6, 8, 9, 14, 15}, 30, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkForTargetTest(int[] nums, int target, boolean hasTarget) {
        assertEquals(hasTarget, OBJ.checkForTarget(nums,target));
    }

    @Test
    void combine() {
        var thing = Arrays.asList(1, 3, 4, 5, 6, 7, 20);
        assertIterableEquals(thing,
                OBJ.combine(new int[]{1, 4, 7, 20}, new int[]{3, 5, 6}));
    }

    @ParameterizedTest
    @CsvSource({"ace, abcde, true", "aec, abcde, false", "bc, abcd, true"})
    void isSubsequence(String s, String t, boolean isSub) {
        assertEquals(isSub, OBJ.isSubsequence(s, t));
    }
}
