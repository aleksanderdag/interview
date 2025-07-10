package org.example.DS.Array;

import java.util.function.Consumer;

public interface Mutable<T> extends Accessor<T> {
    void set(int index, T value);
    void forEach(Consumer<T> function);
    void add(T val);
    Mutable<T> newInstance(int size);

    static IntArray fromIntArray(int[] arr) {
        return new IntArray(arr);
    }
}
