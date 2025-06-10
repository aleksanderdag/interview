package org.example.Cheatsheets.Functions;

import org.example.DS.IAccessor;

public abstract class SlidingWindowSolver<T, C, R> {
    public R ans;
    public C curr;

    protected SlidingWindowSolver() {
        this.ans = initialAns();
        this.curr = initialCurr();
    }

    protected SlidingWindowSolver(R initialAns, C initialCurr) {
        this.ans = initialAns;
        this.curr = initialCurr;
    }

    protected R initialAns() { return null; }
    protected C initialCurr() { return null; }

    // Called when adding arr[right] to the window
    protected abstract void extendRight(T val, int rightIndex);

    // Called when removing arr[left] from the window
    protected abstract void contractLeft(T val, int leftIndex);

    // Condition that tells when the window is broken and left pointer should move forward
    protected abstract boolean windowConditionBroken(int leftIndex, int rightIndex);

    // Called when updating the answer with the current window state
    protected abstract void updateAnswer(int leftIndex, int rightIndex);

    public R solve(IAccessor<T> arr) {
        int left = 0;

        for (int right = 0; right < arr.size(); right++) {
            extendRight(arr.get(right), right);

            while (windowConditionBroken(left, right)) {
                contractLeft(arr.get(left), left);
                left++;
            }

            updateAnswer(left, right);
        }

        return ans;
    }
}
