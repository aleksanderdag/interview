package org.example.DS.List;

import java.util.Iterator;

public abstract class BreakIterator<E> extends IterableAdapter<E> {
    public abstract boolean continueCondition();

    private final Iterator<E> iterator;

    public BreakIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return continueCondition() && iterator.hasNext();
    }

    @Override
    public E next() {
        return iterator.next();
    }
}
