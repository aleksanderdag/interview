package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.Cheatsheets.Solver.ReverseSolver;
import org.example.DS.Array.IntArray;

import java.util.Arrays;

public class InPlace {
    public int[] squareEven(int[] array, int length) {
        // Check for edge cases.
        if (array == null) {
            return array;
        }

        // Iterate through even elements of the original array.
        // Notice how we don't need to do *anything* for the odd indexes? :-)
        for (int i = 0; i < length; i += 2) {

            // Index is an even number, so we need to square the element
            // and replace the original value in the Array.
            array[i] *= array[i];

        }

        // We just return the original array. Some problems on leetcode require you
        // to return it, and other's don`t.
        return array;
    }

    public int[] replaceElements(int[] arr) {
        var collection = new IntArray(arr);

        var test = new ReverseSolver<Integer>() {
            int highest = -1;

            @Override
            public void consume(Integer val) {
                arr[i] = highest;
                highest = Math.max(highest, val);
            }
        };

        test.solve(collection);

        return arr;
    }

    public void moveZeroes(int[] nums) {
        var collection = new IntArray(nums);

        var test = new ForEachSolver<Integer>() {
            int j = 0;

            @Override
            public void consume(Integer val) {
                if (val != 0) {
                    nums[j++] = nums[i];
                }
            }
        };

        test.solve(collection);
        for (; test.j < nums.length; test.j++) {
            nums[test.j] = 0;
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        var collection = new IntArray(nums);

        var test = new ForEachSolver<Integer>() {
            int j = 0;

            @Override
            public void consume(Integer val) {
                if(val % 2 != 1) {
                    int curr = nums[j];
                    nums[j++] = nums[i];
                    nums[i] = curr;
                }
            }
        };

        test.solve(collection);
        Arrays.stream(nums).forEachOrdered(System.out::println);
        return nums;
    }
}
