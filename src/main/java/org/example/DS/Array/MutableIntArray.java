package org.example.DS.Array;

import java.util.function.Consumer;

public class MutableIntArray implements Mutable<Integer> {
    public int length;
    public int[] arr;

    public MutableIntArray(int[] arr) {
        this.arr = arr;
        length = arr.length;
    }

    @Override
    public Integer get(int index) {
        return arr[index];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void set(int index, Integer value) {
        arr[index] = value;
    }

    @Override
    public Mutable<Integer> newInstance(int size) {
        var item = new MutableIntArray(new int[size]);
        item.length = 0;
        return item;
    }

    @Override
    public void forEach(Consumer<Integer> function) {
        for (int elem : arr) {
            function.accept(elem);
        }
    }

    @Override
    public void add(Integer val) {
        if (length != arr.length) arr[length++] = val;
    }
}
