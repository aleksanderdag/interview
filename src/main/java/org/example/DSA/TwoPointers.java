package org.example.DSA;

import org.example.Cheatsheets.Functions.TwoIndices.PointerDecision;
import org.example.Cheatsheets.Functions.TwoIndices.TwoPointerSolver;
import org.example.Cheatsheets.Functions.TwoIndices.TailDecision;
import org.example.Cheatsheets.Functions.TwoIndices.DualPointerSolver;
import org.example.Cheatsheets.JavaMethodFlattener;
import org.example.DS.IAccessor;

import java.util.ArrayList;
import java.util.List;

import static org.example.Cheatsheets.Functions.TwoIndices.PointerDecision.*;

public class TwoPointers {
    public boolean checkIfPalindrome(String s) {
        class myClass extends TwoPointerSolver<Character, Boolean> {
            @Override
            protected Boolean initialAns() {
                return true;
            }

            @Override
            protected PointerDecision<Boolean> doLogic(Character leftVal, Character rightVal, int LeftIndex, int rightIndex, Boolean currentAns) {
                if(leftVal.equals(rightVal)) {
                    return symmetricMove(currentAns);
                } else {
                    return ret(false);
                }
            }
        }

        var palindrome = new myClass();
        return palindrome.solve(IAccessor.fromString(s));
    }

    public boolean checkForTarget(int[] nums, int target) {
        var test = new TwoPointerSolver<Integer, Boolean>() {
            @Override
            protected Boolean initialAns() {
                return false;
            }

            @Override
            protected PointerDecision<Boolean> doLogic(Integer leftVal, Integer rightVal, int LeftIndex, int rightIndex, Boolean currentAns) {
                var total = leftVal + rightVal;
                if (total == target) {
                    return ret(true);
                } else if (total < target) {
                    return moveLeft(currentAns);
                } else {
                    return moveRight(currentAns);
                }
            }
        };

        return test.solve(IAccessor.fromIntArray(nums));
    }

    public java.util.List<Integer> combine(int[] arr1, int[] arr2) {
        DualPointerSolver<Integer, Integer, List<Integer>> test = new DualPointerSolver<>() {
            @Override
            protected List<Integer> initialAns() {
                return new ArrayList<>();
            }

            @Override
            protected PointerDecision<List<Integer>> doLogic(Integer a, Integer b, int i, int j, List<Integer> currentAns) {
                if (a <= b) {
                    currentAns.add(a);
                    return moveLeft(currentAns);
                } else {
                    currentAns.add(b);
                    return moveRight(currentAns);
                }
            }

            @Override
            protected TailDecision<List<Integer>> tailLeft(Integer a, int i, List<Integer> currentAns) {
                currentAns.add(a);
                return TailDecision.cont(currentAns);
            }

            @Override
            protected TailDecision<List<Integer>> tailRight(Integer b, int j, List<Integer> currentAns) {
                currentAns.add(b);
                return TailDecision.cont(currentAns);
            }
        };

        return test.solve(IAccessor.fromIntArray(arr1), IAccessor.fromIntArray(arr2));
    }

    public boolean isSubsequence(String s, String t) {
        var test = new DualPointerSolver<Character, Character, Boolean>() {
            @Override
            protected Boolean initialAns() {
                return true;
            }

            @Override
            protected PointerDecision<Boolean> doLogic(Character a, Character b, int i, int j, Boolean currentAns) {
                if (a == b) {
                    return symmetricMove(currentAns);
                } else {
                    return moveRight(currentAns);
                }
            }

            @Override
            protected TailDecision<Boolean> tailLeft(Character a, int i, Boolean currentAns) {
                return TailDecision.ret(false);
            }

            @Override
            protected TailDecision<Boolean> tailRight(Character b, int j, Boolean currentAns) {
                return TailDecision.ret(true);
            }
        };

        return test.solve(IAccessor.fromString(s), IAccessor.fromString(t));
    }

}
