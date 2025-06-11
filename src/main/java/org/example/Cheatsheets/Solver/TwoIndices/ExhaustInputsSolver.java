package org.example.Cheatsheets.Solver.TwoIndices;

import org.example.DS.Array.Accessor;

public abstract class ExhaustInputsSolver<A, B> {
    protected abstract PointerDecision<?> doLogic(A leftVal, B rightVal, int i, int j);
    protected abstract TailDecision<?> tailLeft(A a, int i);
    protected abstract TailDecision<?> tailRight(B b, int j);

    // Core Logic
    public void solve(Accessor<A> a, Accessor<B> b) {
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            PointerDecision<?> decision = doLogic(a.get(i), b.get(j), i, j);

            if (decision.stopEarly()) break;
            if (decision.moveLeft()) i++;
            if (decision.moveRight()) j++;
        }

        while (i < a.size()) {
            var decision = tailLeft(a.get(i), i);
            if (decision.stopEarly()) break;
            i++;
        }

        while (j < b.size()) {
            var decision = tailRight(b.get(j), j);
            if (decision.stopEarly()) break;
            j++;
        }
    }
}
