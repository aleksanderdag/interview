package org.example.DSA;

public class Util {
    public static int placesMinus1(int num) {
        return (int)Math.log10(num);
    }

    public static int oddParity(int num) {
        return num & 1;
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
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
