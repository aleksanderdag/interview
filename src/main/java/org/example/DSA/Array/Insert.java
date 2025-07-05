package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.Cheatsheets.Solver.ReverseSolver;
import org.example.Cheatsheets.Solver.TwoIndices.ExhaustInputsSolver;
import org.example.Cheatsheets.Solver.TwoIndices.PointerDecision;
import org.example.Cheatsheets.Solver.TwoIndices.TailDecision;
import org.example.DS.Array.IntArray;

import java.util.Arrays;

import static org.example.Cheatsheets.Solver.TwoIndices.PointerDecision.moveLeft;
import static org.example.Cheatsheets.Solver.TwoIndices.PointerDecision.moveRight;
import static org.example.Cheatsheets.Solver.TwoIndices.TailDecision.cont;
import static org.example.DS.Array.Mutable.fromIntArray;

public class Insert {
    public void duplicateZeros(int[] arr) {
        var collection = new IntArray(arr);
        var original = collection.copy();
        collection.length = 0;

        var test = new ForEachSolver<Integer>() {
            int j = 0;

            @Override
            public void consume(Integer val) {
                var jval = original.get(j++);
                collection.add(jval);
                if (jval == 0) {
                    collection.add(jval);
                    i++;
                }
            }
        };

        test.solve(fromIntArray(arr));
        Arrays.stream(arr).forEachOrdered(System.out::println);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var collection = fromIntArray(nums1);
        var collection2 = fromIntArray(nums2);
        collection2.length = n;

        var test = new ReverseSolver<Integer>() {
            int j = m - 1;
            int k = m+n-1;

            @Override
            public void consume(Integer val) {
                while (j>=0 && val < nums1[j]) collection.set(k--, nums1[j--]);
                collection.set(k--, val);
            }
        };

        test.solve(collection2);
        Arrays.stream(nums1).forEachOrdered(System.out::println);
    }
}
