package org.example.Cheatsheets.Functions.TwoIndices.OneCollection;

import org.example.Cheatsheets.Functions.TwoIndices.TwoIndices;

/**
 * Traverse an array based on selector. [currently until indices cross]
 */
public abstract class OneCollection extends TwoIndices {
    @Override
    public boolean continueCondition(int left, int right) {
        return left < right;
    }
}
