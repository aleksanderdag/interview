package org.example.Cheatsheets.Solver;

import org.example.DS.Array.Mutable;

public abstract class PrefixSumSolver<T> {
    protected abstract T combine(T prevSum, T nextVal, int index);

    public Mutable<T> solve(Mutable<T> arr) {
        var prefix = arr.newInstance(arr.size());
        if (arr.size() == 0) return prefix;
        prefix.set(0, arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
//            prefix.set(i, prefix.get(i) + arr.get(i));
            combine(prefix.get(i - 1), prefix.get(i), i);
        }

        return prefix;
    }
}
