package org.example.Cheatsheets.Functions.TwoIndices.OneCollection;

public record PointerDecision<R>(
        boolean stopEarly,
        boolean moveLeft,
        boolean moveRight,
        R updatedAns
) {
    // Convenience constructor for most cases
    public PointerDecision(boolean moveLeft, boolean moveRight, R updatedAns) {
        this(false, moveLeft, moveRight, updatedAns);
    }

    // stop early
    public PointerDecision(boolean stopEarly, R updatedAns) {
        this(stopEarly, false, false, updatedAns);
    }

    public static <R> PointerDecision<R> ret(R ans) {
        return new PointerDecision<>(true, false, false, ans);
    }

    public static <R> PointerDecision<R> moveLeft(R ans) {
        return new PointerDecision<>(false, true, false, ans);
    }

    public static <R> PointerDecision<R> moveRight(R ans) {
        return new PointerDecision<>(false, false, true, ans);
    }
}
