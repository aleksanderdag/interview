package org.example.DS.List.Indexable;

public class IndexableIntArray extends Indexable<Integer>  {
    private final int[] array;

    public IndexableIntArray(int[] array) {
        this.array = array;
    }

    @Override
    public Integer get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return array.length;
    }
}
