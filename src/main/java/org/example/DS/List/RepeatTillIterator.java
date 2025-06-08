package org.example.DS.List;

import java.util.Iterator;

public abstract class RepeatTillIterator<E> extends IterableAdapter<E> {
    private final Iterator<E> iterator;
    private E current;

    public RepeatTillIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        if(current == null || condition()) current = iterator.next();
        return current;
    }

    public abstract boolean condition();
}
