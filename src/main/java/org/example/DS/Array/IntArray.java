package org.example.DS.Array;

import java.util.Arrays;
import java.util.function.Consumer;

public class IntArray implements Mutable<Integer> {
    public int length;
    public int[] arr;

    public IntArray(int[] arr) {
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

    public IntArray copy() {
        int[] copy = new int[length];
        System.arraycopy(arr, 0, copy, 0, length);
        return new IntArray(copy);
    }

    @Override
    public IntArray clone() throws CloneNotSupportedException {
        IntArray clone = (IntArray) super.clone();
        int[] copy = new int[length];
        System.arraycopy(arr, 0, copy, 0, length);
        clone.arr = copy;
        return clone;
    }

    public Mutable<Integer> newInstance(int size) {
        var item = new IntArray(new int[size]);
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
        if (length < arr.length) arr[length++] = val;
    }

    public void insert(int index, Integer val) {
        System.err.println("Warning: This is O(n) compute time, but is in-place [O(n) space].");
        // TODO: length = Math.min(length + 1, arr.length);
        // TODO: test
        for (int i = length; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = val;
    }

    public void delete(int index) {
        System.err.println("Warning: This is O(n) compute time, but is in-place [O(n) space].");
        // TODO: check if index valid and test
        for (int i = index + 1; i < length; i++) {
            arr[index - 1] = arr[i];
        }
        length--;
    }

    public boolean linearSearch(int element) {
        // Check for edge cases. Is the array null or empty?
        // If it is, then we return false because the element we're
        // searching for couldn't possibly be in it.
        if (arr == null || length == 0) {
            return false;
        }

        // Carry out the linear search by checking each element,
        // starting from the first one.
        for (int i = 0; i < length; i++) {
            // We found the element at index i.
            // So we return true to say it exists.
            if (arr[i] == element) {
                return true;
            }
        }

        // We didn't find the element in the array.
        return false;
    }

    public void sort() {
        Arrays.sort(arr);
    }

    // TODO: binary search
}
