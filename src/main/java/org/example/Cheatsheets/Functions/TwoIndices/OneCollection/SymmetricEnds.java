package org.example.Cheatsheets.Functions.TwoIndices.OneCollection;

import org.example.DS.List.Pair;

/**
 * Traverse an array inward from ends symmetrically.
 */
public abstract class SymmetricEnds extends OneCollection {
    /**
     * return update state based indices
     */
    public abstract void update(int leftIndex, int rightIndex);

    @Override
    public Pair<Integer, Integer> selector(int left, int right) {
        update(left, right);
        return new Pair<>(left + 1, right - 1);
    }
}
