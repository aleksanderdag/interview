package org.example.DS.List.Indexable;

public class IndexableCharSequence extends Indexable<Character> {
    private final CharSequence sequence;

    public IndexableCharSequence(CharSequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public Character get(int index) {
        return sequence.charAt(index);
    }

    @Override
    public int size() {
        return sequence.length();
    }
}
