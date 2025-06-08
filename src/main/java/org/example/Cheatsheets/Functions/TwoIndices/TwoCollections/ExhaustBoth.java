package org.example.Cheatsheets.Functions.TwoIndices.TwoCollections;

import org.example.DS.List.Pair;

/**
 * Traverse both arrays, moving along arr1 on condition, else along arr2.
 * Complete traversal after either array is complete.
 */
public abstract class ExhaustBoth extends ConditionalIndex {
    public ExhaustBoth(int arr1Len, int arr2Len) {
        super(arr1Len, arr2Len);
    }

    /**
     * If condition, increase i, else increase j
     */
    public abstract boolean condition(int i, int j);

    public Pair<Integer, Integer> run(int i, int j) {
        var indices = super.run(i, j);
        i = indices.left();
        j = indices.right();

        while (i < arr1Len) {
            trueSelector(i, j);
            i++;
            // TODO: add ans function, i inc - post compare
        }

        while (j < arr2Len) {
            falseSelector(i, j);
            j++;
            // TODO: add ans function, j inc - post compare
        }

        return new Pair<>(i,j);
    }
}
