package org.example.Cheatsheets.Functions;

import org.example.DS.IAccessor;

public abstract class FixedWindowSolver<T, C, R> {
    public R ans;
    public C curr;
    public int k;

    protected FixedWindowSolver() {
        this.ans = initialAns();
        this.curr = initialCurr();
    }

    protected FixedWindowSolver(int k, R initialAns, C initialCurr) {
        this.k = k;
        this.ans = initialAns;
        this.curr = initialCurr;
    }

    protected R initialAns() { return null; }
    protected C initialCurr() { return null; }

    protected abstract void buildingWindow(T val, int rightIndex);
    protected abstract void windowBuilt();
    protected abstract void movingWindow(T excludedVal, int leftIndex, T includedVal, int rightIndex);

    public R solve(IAccessor<T> arr) {
        // build the first window
        for (int i = 0; i < k; i++) {
            buildingWindow(arr.get(i), i);
        }

        windowBuilt();
        for (int i = k; i < arr.size(); i++) {
            movingWindow(arr.get(i - k),  i - k, arr.get(i), i);
        }

        return ans;
    }
}
