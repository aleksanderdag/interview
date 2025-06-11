package org.example.DSA;

import org.example.Cheatsheets.Solver.Window.FixedWindowSolver;
import org.example.Cheatsheets.Solver.Window.SlidingWindowSolver;
import org.example.DS.Array.Accessor;

import static org.example.DS.Array.Mutable.fromIntArray;

public class SlidingWindow {
    public int findLength(int[] nums, int k) {
        var test = new SlidingWindowSolver<Integer, Integer, Integer>(0,0) {
            @Override
            protected void extendRight(Integer val, int rightIndex) {
                this.curr += val;
            }

            @Override
            protected void contractLeft(Integer val, int leftIndex) {
                this.curr -= val;
            }

            @Override
            protected boolean windowConditionBroken(int leftIndex, int rightIndex) {
                return this.curr > k;
            }

            @Override
            protected void updateAnswer(int leftIndex, int rightIndex) {
                this.ans = Math.max(this.ans, rightIndex - leftIndex + 1);
            }
        };

        return test.solve(fromIntArray(nums));
    }

    public int findLength(String s) {
        var test = new SlidingWindowSolver<Character, Integer, Integer>(0, 0) {
            @Override
            protected void extendRight(Character val, int rightIndex) {
                if(val.equals('0')) this.curr++;
            }

            @Override
            protected void contractLeft(Character val, int leftIndex) {
                if(val.equals('0')) this.curr--;
            }

            @Override
            protected boolean windowConditionBroken(int leftIndex, int rightIndex) {
                return this.curr > 1;
            }

            @Override
            protected void updateAnswer(int leftIndex, int rightIndex) {
                this.ans = Math.max(this.ans, rightIndex - leftIndex  + 1);
            }
        };

        return test.solve(Accessor.fromString(s));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        var test = new SlidingWindowSolver<Integer, Integer, Integer>(0, 1) {
            @Override
            protected void extendRight(Integer val, int rightIndex) {
                curr *= val;
            }

            @Override
            protected void contractLeft(Integer val, int leftIndex) {
                curr /= val;
            }

            @Override
            protected boolean windowConditionBroken(int leftIndex, int rightIndex) {
                return curr >= k;
            }

            @Override
            protected void updateAnswer(int leftIndex, int rightIndex) {
                ans +=  rightIndex - leftIndex + 1;
            }
        };

        return test.solve(fromIntArray(nums));
    }

    public int findBestSubarray(int[] nums, int k) {
        var test = new FixedWindowSolver<Integer, Integer, Integer>(k, 0, 0) {
            @Override
            protected void buildingWindow(Integer val, int rightIndex) {
                this.curr += val;
            }

            @Override
            protected void windowBuilt() {
                this.ans = this.curr;
            }

            @Override
            protected void movingWindow(Integer excludedVal, int leftIndex, Integer includedVal, int rightIndex) {
                this.curr += includedVal - excludedVal;
                this.ans = Math.max(this.ans, this.curr);
            }
        };

        return test.solve(fromIntArray(nums));
    }
}
