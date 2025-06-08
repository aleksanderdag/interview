package org.example.Cheatsheets.Functions.TwoIndices.TwoCollections;

import org.example.DS.List.Pair;

public abstract class ConditionalIndex extends TwoCollections {
    public ConditionalIndex(int arr1Len, int arr2Len) {
        super(arr1Len, arr2Len);
    }

    /**
     * If condition, increase i, else increase j
     */
    public abstract boolean condition(int i, int j);
    public abstract Pair<Integer, Integer> trueSelector(int i, int j);
    public abstract Pair<Integer, Integer> falseSelector(int i, int j);

    @Override
    public Pair<Integer, Integer> selector(int i, int j) {
        return condition(i, j) ? trueSelector(i, j) : falseSelector(i, j);
    }
}
