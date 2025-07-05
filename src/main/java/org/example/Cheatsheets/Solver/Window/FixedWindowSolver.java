package org.example.Cheatsheets.Solver.Window;

import org.example.DS.Array.Accessor;

public abstract class FixedWindowSolver<T> {
    public int k;

    protected abstract void buildingWindow(T val, int rightIndex);
    protected abstract void windowBuilt();
    protected abstract void movingWindow(T excludedVal, int leftIndex, T includedVal, int rightIndex);

    public void solve(Accessor<T> arr) {
        // build the first window
        for (int i = 0; i < k; i++) {
            buildingWindow(arr.get(i), i);
        }

        windowBuilt();
        for (int i = k; i < arr.size(); i++) {
            movingWindow(arr.get(i - k),  i - k, arr.get(i), i);
        }
    }
}
