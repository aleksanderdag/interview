package org.example.Cheatsheets.Solver;

import org.example.DS.Array.Accessor;

public abstract class ReverseSolver<T> {
    public int i;

    public abstract void consume(T val);

    public void solve(Accessor<T> accessor) {
        for (i = accessor.size() - 1; i >= 0; i--) {
            consume(accessor.get(i));
        }
    }
}
