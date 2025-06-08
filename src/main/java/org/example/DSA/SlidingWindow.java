package org.example.DSA;

public class SlidingWindow {
    public int findLength(int[] nums, int k) {
        var myState = new org.example.Cheatsheets.Functions.SlidingWindow() {
            int ans = 0;
            int curr = 0;

            @Override
            public void addRight(int rightIndex) {
                curr += nums[rightIndex];
            }

            @Override
            public void removeLeft(int leftIndex) {
                curr -= nums[leftIndex];
            }

            @Override
            public boolean windowConditionBroken(int leftIndex, int rightIndex) {
                return curr > k;
            }

            @Override
            public void validWindow(int leftIndex, int rightIndex) {
                ans = Math.max(ans, rightIndex - leftIndex + 1);
            }
        };
        myState.run(nums.length);

        return myState.ans;
    }

    public int findLength(String s) {
        var myState = new org.example.Cheatsheets.Functions.SlidingWindow() {
            int ans = 0;
            int zeroCount = 0;

            @Override
            public void addRight(int rightIndex) {
                if(s.charAt(rightIndex) == '0') zeroCount++;
            }

            @Override
            public void removeLeft(int leftIndex) {
                if(s.charAt(leftIndex) == '0') zeroCount--;
            }

            @Override
            public boolean windowConditionBroken(int leftIndex, int rightIndex) {
                return zeroCount > 1;
            }

            @Override
            public void validWindow(int leftIndex, int rightIndex) {
                ans = Math.max(ans, rightIndex - leftIndex + 1);
            }
        };
        myState.run(s.length());
        return myState.ans;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        var myState = new org.example.Cheatsheets.Functions.SlidingWindow() {
            int ans = 0;
            int curr = 1;

            @Override
            public void addRight(int rightIndex) {
                curr *= nums[rightIndex];
            }

            @Override
            public void removeLeft(int leftIndex) {
                curr /= nums[leftIndex];
            }

            @Override
            public boolean windowConditionBroken(int leftIndex, int rightIndex) {
                return curr >= k;
            }

            @Override
            public void validWindow(int leftIndex, int rightIndex) {
                ans += rightIndex - leftIndex + 1;
            }
        };
        myState.run(nums.length);
        return myState.ans;
    }

    public int findBestSubarray(int[] nums, int k) { // TODO: add class for fixed windows
        var myState = new org.example.Cheatsheets.Functions.SlidingWindow() {
            int ans = 0, curr = 0, size = 0;

            @Override
            public void addRight(int rightIndex) {
                curr += nums[rightIndex];
                size++;
            }

            @Override
            public void removeLeft(int leftIndex) {
                curr -= nums[leftIndex];
                size--;
            }

            @Override
            public boolean windowConditionBroken(int leftIndex, int rightIndex) {
                return size > k;
            }

            @Override
            public void validWindow(int leftIndex, int rightIndex) {
                ans = Math.max(ans, curr);
            }
        };
        myState.run(nums.length);
        return myState.ans;
    }
}
