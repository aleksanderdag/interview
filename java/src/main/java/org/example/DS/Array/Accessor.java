package org.example.DS.Array;

public interface Accessor<T> {
    T get(int index);
    int size();

    static Accessor<Character> fromString(String str) {
        return new StringArray(str);
    }
}
