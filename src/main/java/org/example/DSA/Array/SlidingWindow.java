package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.Window.FixedWindowSolver;
import org.example.Cheatsheets.Solver.Window.SlidingWindowSolver;
import org.example.DS.Array.Accessor;

import static org.example.DS.Array.Mutable.fromIntArray;

public class SlidingWindow {
    /***
     * find the length of the longest subarray whose sum is less than or equal to k
     *
     * @param nums  an array of positive integers
     * @param k     an integer
     * @return  the length of the longest subarray whose sum is less than or equal to k
     */
    public int findLength(int[] nums, int k) {
        var test = new SlidingWindowSolver<Integer>() {
            int ans = 0;
            int curr = 0;

            @Override
            protected void extendRight(Integer val, int rightIndex) {
                this.curr += val;
            }

            @Override
            protected void contractLeft(Integer val, int leftIndex) {
                this.curr -= val;
            }

            @Override
            protected boolean windowConditionBroken() {
                return this.curr > k;
            }

            @Override
            protected void updateAnswer() {
                this.ans = Math.max(this.ans, right - left + 1);
            }
        };

        test.solve(fromIntArray(nums));
        return test.ans;
    }

    public int findLength(String s) {
        var test = new SlidingWindowSolver<Character>() {
            int ans = 0;
            int curr = 0;

            @Override
            protected void extendRight(Character val, int rightIndex) {
                if(val.equals('0')) this.curr++;
            }

            @Override
            protected void contractLeft(Character val, int leftIndex) {
                if(val.equals('0')) this.curr--;
            }

            @Override
            protected boolean windowConditionBroken() {
                return this.curr > 1;
            }

            @Override
            protected void updateAnswer() {
                this.ans = Math.max(this.ans, right - left  + 1);
            }
        };

        test.solve(Accessor.fromString(s));
        return test.ans;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        var test = new SlidingWindowSolver<Integer>() {
            int ans = 0;
            int curr = 1;

            @Override
            protected void extendRight(Integer val, int rightIndex) {
                curr *= val;
            }

            @Override
            protected void contractLeft(Integer val, int leftIndex) {
                curr /= val;
            }

            @Override
            protected boolean windowConditionBroken() {
                return curr >= k;
            }

            @Override
            protected void updateAnswer() {
                ans +=  right - left + 1;
            }
        };

        test.solve(fromIntArray(nums));
        return test.ans;
    }

    public int findBestSubarray(int[] nums, int k) {
        var test = new FixedWindowSolver<Integer>() {
            int ans = 0;
            int curr = 0;

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

        test.k = k;
        test.solve(fromIntArray(nums));
        return test.ans;
    }
}
