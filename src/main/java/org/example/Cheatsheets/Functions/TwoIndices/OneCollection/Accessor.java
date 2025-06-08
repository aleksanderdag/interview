package org.example.Cheatsheets.Functions.TwoIndices.OneCollection;

public class Accessor {
    public static IAccessor<Character> fromString(String str) {
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

    public static IAccessor<Integer> fromIntArray(int[] arr) {
        return new IAccessor<Integer>() {
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
