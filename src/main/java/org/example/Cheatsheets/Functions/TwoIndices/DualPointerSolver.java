package org.example.Cheatsheets.Functions.TwoIndices;

import org.example.DS.IAccessor;

public abstract class DualPointerSolver<A, B, R> {
    protected abstract R initialAns();
    protected abstract PointerDecision<R> doLogic(A leftVal, B rightVal, int i, int j, R currentAns);
    protected abstract TailDecision<R> tailLeft(A a, int i, R currentAns);
    protected abstract TailDecision<R> tailRight(B b, int j, R currentAns);

    // Core Logic
    public R solve(IAccessor<A> a, IAccessor<B> b) {
        int i = 0, j = 0;
        R ans = initialAns();

        while (i < a.size() && j < b.size()) {
            PointerDecision<R> decision = doLogic(a.get(i), b.get(j), i, j, ans);
            ans = decision.updatedAns();

            if (decision.stopEarly()) break;
            if (decision.moveLeft()) i++;
            if (decision.moveRight()) j++;
        }

        while (i < a.size()) {
            var decision = tailLeft(a.get(i), i, ans);
            ans = decision.updatedAns();
            if (decision.stopEarly()) break;
            i++;
        }

        while (j < b.size()) {
            var decision = tailRight(b.get(j), j, ans);
            ans = decision.updatedAns();
            if (decision.stopEarly()) break;
            j++;
        }

        return ans;
    }
}
