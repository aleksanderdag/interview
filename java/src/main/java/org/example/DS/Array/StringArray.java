package org.example.DS.Array;

public class StringArray implements Accessor<Character> {
    public String str;

    public StringArray(String str) {
        this.str = str;
    }

    public StringArray(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        str = sb.toString();
    }

    @Override
    public Character get(int index) {
        return str.charAt(index);
    }

    @Override
    public int size() {
        return str.length();
    }
}
