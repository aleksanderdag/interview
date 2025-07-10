package org.example.Cheatsheets.Solver.TwoIndices;

import org.example.DS.Array.Accessor;

public abstract class OppositeEndsSolver<T> {
    public int left;
    public int right;

    protected abstract PointerDecision<?> doLogic(T leftVal, T rightVal, int LeftIndex, int rightIndex);

    // Core Logic
    public void solve(Accessor<T> accessor) {
        left = 0;
        right = accessor.size() - 1;

        while (left < right) {
            PointerDecision<?> decision = doLogic(accessor.get(left), accessor.get(right), left, right);

            if (decision.stopEarly()) break;
            if (decision.moveLeft()) left++;
            if (decision.moveRight()) right--;
        }
    }
}
