package org.example.DS.Array;

import java.util.function.Consumer;

public interface Mutable<T> extends Accessor<T> {
    void set(int index, T value);
    Mutable<T> newInstance(int size);
    void forEach(Consumer<T> function);
    void add(T val);

    static MutableIntArray fromIntArray(int[] arr) {
        return new MutableIntArray(arr);
    }
}
