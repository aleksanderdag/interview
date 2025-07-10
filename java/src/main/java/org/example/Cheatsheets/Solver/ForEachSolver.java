package org.example.Cheatsheets.Solver;

import org.example.DS.Array.Accessor;

public abstract class ForEachSolver<T> {
    public int i = 0;

    public abstract void consume(T val);

    public void solve(Accessor<T> accessor) {
        for (; i < accessor.size(); i++) {
            consume(accessor.get(i));
        }
    }
}
