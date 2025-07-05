package org.example.DS.List;

import java.util.Arrays;

public class AList<E> {
    private Object[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public AList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    private void grow(int minCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        data = Arrays.copyOf();
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) grow(minCapacity);
    }

    public void add(E e) {
    }
}
