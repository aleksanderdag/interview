package org.example.Cheatsheets.Functions.TwoIndices.OneCollection;

import org.example.DS.List.Pair;

/**
 * Traverse an array from opposite sides, moving left on condition, else right.
 */
public abstract class OppositeEnds extends OneCollection {
    /**
     * If condition, move left index right, else move right index left
     */
    public abstract boolean condition(int leftIndex, int rightIndex);

    @Override
    public Pair<Integer, Integer> selector(int left, int right) {
        return condition(left, right) ? new Pair<>(left + 1, right) : new Pair<>(left, right - 1);
    }
}
