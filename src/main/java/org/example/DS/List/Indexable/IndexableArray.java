package org.example.DS.List.Indexable;

public class IndexableArray<T> extends Indexable<T> {
    private final T[] array;

    public IndexableArray(T[] array) {
        this.array = array;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return array.length;
    }
}
