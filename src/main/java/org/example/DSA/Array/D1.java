package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.Cheatsheets.Solver.ReverseSolver;
import org.example.DS.Array.IntArray;

import java.util.Arrays;

public class D1 {
    public int pivotIndex(int[] nums) {
        var collection = new IntArray(nums);
        var total = 0;
        for(int n : nums) total += n;
        final var t = total;

        var test = new ForEachSolver<Integer>() {
            int ans = -1;
            int curr = 0;
            int leftTotal = 0;
            int rightTotal = t;

            @Override
            public void consume(Integer val) {
                leftTotal += curr;
                curr = val;
                rightTotal -= val;
                if (leftTotal == rightTotal) {
                    ans = i;
                    // break;
                    i = nums.length;
                }
            }
        };

        test.solve(collection);
        return test.ans;
    }

    public int dominantIndex(int[] nums) {
        var collection = new IntArray(nums);

        var test = new ForEachSolver<Integer>() {
            int index = -1;
            int largest = 0;
            int secondLargest = 0;

            @Override
            public void consume(Integer val) {
                if(val > secondLargest) {
                    if(val > largest) {
                        secondLargest = largest;
                        largest = val;
                        index = i;
                    } else {
                        secondLargest = val;
                    }
                }
            }
        };

        test.solve(collection);
        return test.largest >= test.secondLargest * 2 ? test.index : -1;
    }

    public int[] plusOne(int[] digits) {
        var collection = new IntArray(digits);

        var test = new ReverseSolver<Integer>() {
            int remainder = 1;

            @Override
            public void consume(Integer val) {
                val++;
                if(val < 10) {
                    digits[i] = val;
                    i=-1;
                    remainder = 0;
                } else {
                    digits[i] = 0;
                }
            }
        };

        test.solve(collection);
        if (test.remainder == 0) return digits;
        else {
            var mine = new int[digits.length+1];
            mine[0] = 1;
            return mine;
        }
    }
}
