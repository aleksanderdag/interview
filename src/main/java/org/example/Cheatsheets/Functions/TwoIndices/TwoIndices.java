package org.example.Cheatsheets.Functions.TwoIndices;

import org.example.DS.List.Pair;

public abstract class TwoIndices {
    /**
     * Stops indices traversal
     */
    public abstract boolean continueCondition(int i, int j);
    /**
     * Return next indices
     */
    public abstract Pair<Integer, Integer> selector(int leftIndex, int rightIndex);

    public Pair<Integer, Integer> run(int i, int j) {
        var pair = new Pair<>(i,j);
        while (continueCondition(pair.left(), pair.right())) {
            pair = selector(pair.left(), pair.right());
        }
        return pair;
    }
}
