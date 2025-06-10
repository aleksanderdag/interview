package org.example.DS;

public interface IAccessor<T> {
    T get(int index);
    int size();

    static IAccessor<Character> fromString(String str) {
        return new IAccessor<>() {
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

    static IAccessor<Integer> fromIntArray(int[] arr) {
        return new IAccessor<>() {
            @Override
            public Integer get(int index) {
                return arr[index];
            }

            @Override
            public int size() {
                return arr.length;
            }
        };
    }
}
