package org.example.Cheatsheets.Functions.TwoIndices.OneCollection;

public abstract class TwoPointerSolver<T, R> {
    protected abstract R initialAns();
    protected abstract PointerDecision<R> doLogic(T leftVal, T rightVal, int LeftIndex, int rightIndex, R currentAns);

    // Core Logic
    public R solve(IAccessor<T> accessor) {
        int left = 0;
        int right = accessor.size() - 1;
        R ans = initialAns();

        while (left < right) {
            PointerDecision<R> decision = doLogic(accessor.get(left), accessor.get(right), left, right, ans);
            ans = decision.updatedAns();

            if (decision.stopEarly()) break;
            if (decision.moveLeft()) left++;
            if (decision.moveRight()) right--;
        }

        return ans;
    }
}
