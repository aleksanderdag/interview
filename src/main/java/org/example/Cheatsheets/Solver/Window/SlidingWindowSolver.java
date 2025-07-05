package org.example.Cheatsheets.Solver.Window;

import org.example.DS.Array.Accessor;

public abstract class SlidingWindowSolver<T> {
    public int left = 0;
    public int right = 0;

    // Called when adding arr[right] to the window
    protected abstract void extendRight(T val, int rightIndex);

    // Called when removing arr[left] from the window
    protected abstract void contractLeft(T val, int leftIndex);

    // Condition that tells when the window is broken and left pointer should move forward
    protected abstract boolean windowConditionBroken(T leftVal, T rightVal);

    // Called when updating the answer with the current window state
    protected abstract void updateAnswer();

    public void solve(Accessor<T> arr) {
        for (; right < arr.size(); right++) {
            extendRight(arr.get(right), right);

            while (windowConditionBroken(arr.get(left), arr.get(right))) {
                contractLeft(arr.get(left), left);
                left++;
            }

            updateAnswer();
        }
    }
}
