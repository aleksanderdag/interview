package org.example.DS;

public interface Collection<E> { // TODO: use iterator
    // iterator functions:
    E next();
    boolean hasNext();
    void remove();

    void add(E element);
}
