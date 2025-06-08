package org.example.DS.List.Indexable;

import java.util.Iterator;

// iterator -> indexIterator
public class IndexIteratorWrapper<T, E> implements IndexIterator<T> {
    Iterator<T> iterator;
    IndexIterator<E> baseIterator;

    public IndexIteratorWrapper(Iterator<T> iterator, IndexIterator<E> baseIterator) {
        this.iterator = iterator;
        this.baseIterator = baseIterator;
    }

    @Override
    public int getIndex() {
        return baseIterator.getIndex();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return iterator.next();
    }
}
