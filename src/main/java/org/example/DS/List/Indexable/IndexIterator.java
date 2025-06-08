package org.example.DS.List.Indexable;

import java.util.Iterator;

public interface IndexIterator<E> extends Iterator<E> {
    int getIndex();
}
