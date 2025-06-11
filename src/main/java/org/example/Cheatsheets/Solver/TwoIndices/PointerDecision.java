package org.example.Cheatsheets.Solver.TwoIndices;

public record PointerDecision<R>(
        boolean stopEarly,
        boolean moveLeft,
        boolean moveRight,
        R updatedAns
) {
    public static <R> PointerDecision<R> ret(R ans) {
        return new PointerDecision<>(true, false, false, ans);
    }

    public static <R> PointerDecision<R> symmetricMove(R ans) {
        return new PointerDecision<>(false, true, true, ans);
    }

    public static <R> PointerDecision<R> moveLeft(R ans) {
        return new PointerDecision<>(false, true, false, ans);
    }

    public static <R> PointerDecision<R> moveRight(R ans) {
        return new PointerDecision<>(false, false, true, ans);
    }
}
