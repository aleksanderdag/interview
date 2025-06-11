package org.example.Cheatsheets.Solver.TwoIndices;

public record TailDecision<R>(boolean stopEarly, R updatedAns) {
    public static <R> TailDecision<R> cont(R ans) {
        return new TailDecision<R>(false, ans);
    }

    public static <R> TailDecision<R> ret(R ans) {
        return new TailDecision<>(true, ans);
    }
}
