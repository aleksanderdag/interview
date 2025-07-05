package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.DS.Array.IntArray;

import java.util.Arrays;

public class Conclusion {
    public int heightChecker(int[] heights) {
        var collection = new IntArray(heights);
        var sorted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorted);

        var test = new ForEachSolver<Integer>() {
            int count = 0;

            @Override
            public void consume(Integer val) {
                if (sorted[i] != heights[i]) count++;
            }
        };

        test.solve(collection);
        return test.count;
    }
}
