package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.DS.Array.IntArray;

import java.util.Arrays;

public class Delete {
    public int removeElement(int[] nums, int val) {
        var collection = new IntArray(nums);

        var test = new ForEachSolver<Integer>() {
            int k = 0;

            @Override
            public void consume(Integer ival) {
                if (ival != val) collection.set(k++, ival);
            }
        };

        test.solve(collection);
        collection.length = test.k;
        Arrays.stream(nums).forEachOrdered(System.out::println);
        return collection.length;
    }

    public int removeDuplicates(int[] nums) {
        // Check for edge cases.
        var collection = new IntArray(nums);

        var test = new ForEachSolver<Integer>() {
            // Use the two pointer technique to remove the duplicates in-place.
            // The first element shouldn't be touched; it's already in its correct place.
            int k = 0;

            // Go through each element in the Array.
            @Override
            public void consume(Integer val) {
                // If the current element we're reading is *different* to the previous
                // element...
                if (val != nums[k]) {
                    // Copy it into the next position at the front, tracked by writePointer.
                    // And we need to now increment writePointer, because the next element
                    // should be written one space over.
                    nums[++k] = nums[i];
                }
            }
        };

        test.i++;
        System.out.println(test.i);
        test.solve(collection);
        collection.length = test.k + 1;
        Arrays.stream(nums).forEachOrdered(System.out::println);
        // This turns out to be the correct length value.
        return collection.length;
    }
}
