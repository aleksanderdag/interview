package org.example.DSA;

import org.example.Cheatsheets.Functions.TwoIndices.OneCollection.Accessor;
import org.example.Cheatsheets.Functions.TwoIndices.OneCollection.PointerDecision;
import org.example.Cheatsheets.Functions.TwoIndices.OneCollection.TwoPointerSolver;
import org.example.DS.List.Pair;
import org.example.Cheatsheets.Functions.TwoIndices.TwoCollections.ConditionalIndex;

import static org.example.Cheatsheets.Functions.TwoIndices.OneCollection.PointerDecision.*;

public class TwoPointers {
    public boolean checkIfPalindrome(String s) {
        TwoPointerSolver<Character, Boolean> palindrome = new TwoPointerSolver<>() {
            @Override
            protected Boolean initialAns() {
                return true;
            }

            @Override
            protected PointerDecision<Boolean> doLogic(Character leftVal, Character rightVal, int LeftIndex, int rightIndex, Boolean currentAns) {
                if(leftVal.equals(rightVal)) {
                    return new PointerDecision<>(true, true, currentAns);
                } else {
                    return ret(false);
                }
            }
        };

        return palindrome.solve(Accessor.fromString(s));
    }

    public boolean checkForTarget(int[] nums, int target) {
        TwoPointerSolver<Integer, Boolean> test = new TwoPointerSolver<>() {
            @Override
            protected Boolean initialAns() {
                return false;
            }

            @Override
            protected PointerDecision<Boolean> doLogic(Integer leftVal, Integer rightVal, int LeftIndex, int rightIndex, Boolean currentAns) {
                int total = leftVal + rightVal;
                if (total == target) {
                    return ret(true);
                } else if (total < target) {
                    return moveLeft(currentAns);
                } else {
                    return moveRight(currentAns);
                }
            }
        };

        return test.solve(Accessor.fromIntArray(nums));
    }

//    public java.util.List<Integer> combine(int[] arr1, int[] arr2) {
//        var collection1 = new IndexableIntArray(arr1);
//        var items1 = collection1.iterator();
//        var collection2 = new IndexableIntArray(arr1);
//        var items2 = collection2.iterator();
//        var items = new CombineIterator<>(items1, items2);
//
//        for(var elem : items) {
//
//        }
//
//        return
//
////        var myState = new ExhaustBoth(arr1.length, arr2.length) {
////            java.util.List<Integer> state = new ArrayList<>();
////
////            @Override
////            public boolean condition(int i, int j) {
////                return arr1[i] < arr2[j];
////            }
////
////            @Override
////            public Pair<Integer, Integer> trueSelector(int i, int j) {
////                state.add(arr1[i]);
////                return new Pair<>(i + 1, j);
////            }
////
////            @Override
////            public Pair<Integer, Integer> falseSelector(int i, int j) {
////                state.add(arr2[j]);
////                return new Pair<>(i, j + 1);
////            }
////        };
////        myState.run(0,0);
////        return myState.state;
//    }

    public boolean isSubsequence(String s, String t) {
        var myState = new ConditionalIndex(s.length(), t.length()) {
            @Override
            public boolean condition(int i, int j) {
                return s.charAt(i) == t.charAt(j);
            }

            @Override
            public Pair<Integer, Integer> trueSelector(int i, int j) {
                return new Pair<>(i + 1, j + 1);
            }

            @Override
            public Pair<Integer, Integer> falseSelector(int i, int j) {
                return new Pair<>(i, j + 1);
            }
        };

        return myState.run(0, 0).left() == s.length();
    }

}
