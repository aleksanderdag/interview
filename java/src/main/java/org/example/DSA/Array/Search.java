package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.DS.Array.IntArray;

public class Search {
    public boolean checkIfExist(int[] arr) {
        var collection = new IntArray(arr);
//        var seen = new HashSet<Integer>();

        var test = new ForEachSolver<Integer>() {
            boolean ans = false;

            @Override
            public void consume(Integer val) {
                int index = collection.firstIndex(val*2);
                if(index != -1 && index != i) ans = true;
//                if(seen.contains(val*2) || val % 2 == 0 && seen.contains(val/2)) {
//                    ans = true;
//                    // break
//                    i = arr.length;
//                }
//
//                seen.add(val);
            }
        };

        test.solve(collection);
        return test.ans;
    }

    // TODO: add support for changing logic
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int i = 0;
        // find downhill point
        for (; i < arr.length - 1 && arr[i] < arr[i+1]; i++);
        if (i == 0 || i == arr.length - 1) return false;
        // find uphill point
        for (; i < arr.length - 1 && arr[i] > arr[i+1]; i++);

        return i == arr.length - 1;

//        var collection = new IntArray(arr);
//        if (collection.size() < 3) return false;
//
//        var test = new ForEachSolver<Integer>() {
//            boolean ans = true;
//            boolean inclined = false;
//            boolean decline = false;
//            boolean peak = false;
//
//            @Override
//            public void consume(Integer val) {
//                int prev = collection.get(i-1);
//                int next = collection.get(i+1);
//
//                // flat or valley
//                if(prev == val || prev >= val && val <= next) {
//                    ans=false;
//                    i=arr.length;
//                }
//
//                // peak
//                if(prev < val && val > next) {
//                    if(peak) {
//                        ans=false;
//                        i=arr.length;
//                    } else {
//                        peak = true;
//                    }
//                }
//
////                int curr = val - prev;
////                if (!decline) {
////                    if (curr == 0) ans = false;
////                    if (curr < 0) decline = true;
////                    else inclined = true;
////                } else {
////                    if (curr >= 0) ans = false;
////                }
//            }
//        };
//
//        collection.length = collection.length-1;
//        test.i = 1;
//        test.solve(collection);
//        return test.ans && test.peak;
    }
}
