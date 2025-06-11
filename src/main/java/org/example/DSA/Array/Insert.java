package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.Cheatsheets.Solver.TwoIndices.ExhaustInputsSolver;
import org.example.Cheatsheets.Solver.TwoIndices.PointerDecision;
import org.example.Cheatsheets.Solver.TwoIndices.TailDecision;

import java.util.Arrays;

import static org.example.Cheatsheets.Solver.TwoIndices.PointerDecision.moveLeft;
import static org.example.Cheatsheets.Solver.TwoIndices.PointerDecision.moveRight;
import static org.example.Cheatsheets.Solver.TwoIndices.TailDecision.cont;
import static org.example.DS.Array.Mutable.fromIntArray;

public class Insert {
    public void duplicateZeros(int[] arr) {
        var collection = fromIntArray(arr);
        var original = collection.newInstance(collection.size());

        var pretest = new ForEachSolver<Integer>() {
            @Override
            public void consume(Integer val) {
                original.set(i, val);
            }
        };

        pretest.solve(collection);
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
        var original = collection.newInstance(collection.size());
        collection.length = m;

        var pretest = new ForEachSolver<Integer>() {
            @Override
            public void consume(Integer val) {
                original.add(val);
            }
        };

        pretest.solve(collection);
        collection.length = 0;

        var test = new ExhaustInputsSolver<Integer, Integer>() {
            @Override
            protected PointerDecision<?> doLogic(Integer leftVal, Integer rightVal, int i, int j) {
                if (leftVal < rightVal) {
                    collection.add(leftVal);
                    return moveLeft(null);
                } else {
                    collection.add(rightVal);
                    return moveRight(null);
                }
            }

            @Override
            protected TailDecision<?> tailLeft(Integer integer, int i) {
                collection.add(integer);
                return cont(null);
            }

            @Override
            protected TailDecision<?> tailRight(Integer integer, int j) {
                collection.add(integer);
                return cont(null);
            }
        };

        test.solve(original, fromIntArray(nums2));
        Arrays.stream(nums1).forEachOrdered(System.out::println);
    }
}
