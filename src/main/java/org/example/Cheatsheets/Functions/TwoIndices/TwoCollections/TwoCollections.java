package org.example.Cheatsheets.Functions.TwoIndices.TwoCollections;

import org.example.Cheatsheets.Functions.TwoIndices.TwoIndices;

public abstract class TwoCollections extends TwoIndices {
    int arr1Len;
    int arr2Len;
    public TwoCollections(int arr1Len, int arr2Len) {
        this.arr1Len = arr1Len;
        this.arr2Len = arr2Len;
    }

    @Override
    public boolean continueCondition(int i, int j) {
        return i < arr1Len && j < arr2Len;
    }
}
