package org.example.DSA;

import org.example.Cheatsheets.Solver.TwoIndices.PointerDecision;
import org.example.Cheatsheets.Solver.TwoIndices.OppositeEndsSolver;
import org.example.Cheatsheets.Solver.TwoIndices.TailDecision;
import org.example.Cheatsheets.Solver.TwoIndices.ExhaustInputsSolver;
import org.example.DS.Array.Accessor;

import java.util.ArrayList;
import java.util.List;

import static org.example.Cheatsheets.Solver.TwoIndices.PointerDecision.*;
import static org.example.DS.Array.Mutable.fromIntArray;

public class TwoPointers {
    public boolean checkIfPalindrome(String s) {
        class myClass extends OppositeEndsSolver<Character> {
            boolean ans = true;

            @Override
            protected PointerDecision<Boolean> doLogic(Character leftVal, Character rightVal, int LeftIndex, int rightIndex) {
                if(leftVal.equals(rightVal)) {
                    return symmetricMove(null);
                } else {
                    this.ans = false;
                    return ret(false);
                }
            }
        }

        var palindrome = new myClass();
        palindrome.solve(Accessor.fromString(s));
        return palindrome.ans;
    }

    public boolean checkForTarget(int[] nums, int target) {
        var test = new OppositeEndsSolver<Integer>() {
            boolean ans = false;

            @Override
            protected PointerDecision<Boolean> doLogic(Integer leftVal, Integer rightVal, int LeftIndex, int rightIndex) {
                var total = leftVal + rightVal;
                if (total == target) {
                    this.ans = true;
                    return ret(true);
                } else if (total < target) {
                    return moveLeft(null);
                } else {
                    return moveRight(null);
                }
            }
        };

        test.solve(fromIntArray(nums));
        return test.ans;
    }

    public java.util.List<Integer> combine(int[] arr1, int[] arr2) {
        var test = new ExhaustInputsSolver<Integer, Integer>() {
            public final List<Integer> ans = new ArrayList<>();

            @Override
            protected PointerDecision<List<Integer>> doLogic(Integer a, Integer b, int i, int j) {
                if (a <= b) {
                    ans.add(a);
                    return moveLeft(null);
                } else {
                    ans.add(b);
                    return moveRight(null);
                }
            }

            @Override
            protected TailDecision<List<Integer>> tailLeft(Integer a, int i) {
                ans.add(a);
                return TailDecision.cont(null);
            }

            @Override
            protected TailDecision<List<Integer>> tailRight(Integer b, int j) {
                ans.add(b);
                return TailDecision.cont(null);
            }
        };

        test.solve(fromIntArray(arr1), fromIntArray(arr2));
        return test.ans;
    }

    public boolean isSubsequence(String s, String t) {
        var test = new ExhaustInputsSolver<Character, Character>() {
            boolean ans = true;

            @Override
            protected PointerDecision<?> doLogic(Character a, Character b, int i, int j) {
                if (a == b) {
                    return symmetricMove(null);
                } else {
                    return moveRight(null);
                }
            }

            @Override
            protected TailDecision<?> tailLeft(Character a, int i) {
                ans = false;
                return TailDecision.ret(null);
            }

            @Override
            protected TailDecision<?> tailRight(Character b, int j) {
                return TailDecision.ret(null);
            }
        };

        test.solve(Accessor.fromString(s), Accessor.fromString(t));
        return test.ans;
    }

}
