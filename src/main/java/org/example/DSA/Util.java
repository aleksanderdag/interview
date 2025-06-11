package org.example.DSA;

public class Util {
    public static int placesMinus1(int num) {
        return (int)Math.log10(num);
    }

    public static int oddParity(int num) {
        return num & 1;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, count = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }

        ans = Math.max(ans, count);
        return ans;
    }
}
