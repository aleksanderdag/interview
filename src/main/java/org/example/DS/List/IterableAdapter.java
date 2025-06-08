package org.example.DS.List;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public abstract class IterableAdapter<T> implements Iterable<T>, Iterator<T> {
    @Override
    public @NotNull Iterator<T> iterator() {
        return this;
    }
}
