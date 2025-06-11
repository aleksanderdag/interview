package org.example.DS.Array;

public interface Accessor<T> {
    T get(int index);
    int size();

    static Accessor<Character> fromString(String str) {
        return new Accessor<>() {
            @Override
            public Character get(int index) {
                return str.charAt(index);
            }

            @Override
            public int size() {
                return str.length();
            }
        };
    }
}
