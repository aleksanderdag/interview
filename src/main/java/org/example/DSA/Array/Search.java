package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.Cheatsheets.Solver.Window.SlidingWindowSolver;
import org.example.DS.Array.IntArray;

import java.util.Arrays;
import java.util.Objects;

public class Search {
    public boolean checkIfExist(int[] arr) {
//        var collection = new IntArray(arr);
//        collection.sort();
//
//        var test = new SlidingWindowSolver<Integer>() {
//            boolean ans = false;
//
//            @Override
//            protected void extendRight(Integer val, int rightIndex) {
//
//            }
//
//            @Override
//            protected void contractLeft(Integer val, int leftIndex) {
//
//            }
//
//            @Override
//            protected boolean windowConditionBroken(Integer leftVal, Integer rightVal) {
//                return leftVal * 2 < rightVal;
//            }
//
//            @Override
//            protected void updateAnswer() {
//                if(collection.get(left) * 2 == collection.get(right)) ans = true;
//            }
//        };
//
//        test.right++;
//        test.solve(collection);
//        return test.ans;

        Arrays.sort(arr);
        Arrays.stream(arr).forEachOrdered(System.out::println);
        int l = 0, r = l + 1, doubleRight = arr[r] * 2;

        while (doubleRight < 0) {
            while (doubleRight < arr[l]) {
                r++;
                if (r >= arr.length) return false;
                doubleRight = 2 * arr[r];
            }
            if (arr[l] == doubleRight && l != r) return true;
            l++;
        }

        int doubleLeft = 2 * arr[l];

        while (r < arr.length) {
            while (doubleLeft < arr[r]) doubleLeft = 2 * arr[++l];
            if (arr[r] == doubleLeft && l != r) return true;
            r++;
        }

        return false;
    }

    public boolean validMountainArray(int[] arr) {
        var collection = new IntArray(arr);
        if (collection.size() < 3) return false;

        var test = new ForEachSolver<Integer>() {
            boolean ans = true;
            boolean inclined = false;
            boolean decline = false;

            @Override
            public void consume(Integer val) {
                int prev = collection.get(i-1);
                int curr = val - prev;
                if (!decline) {
                    if (curr == 0) ans = false;
                    if (curr < 0) decline = true;
                    else inclined = true;
                } else {
                    if (curr >= 0) ans = false;
                }
            }
        };

        test.i = 1;
        test.solve(collection);
        return test.ans && test.decline && test.inclined;
    }
}
