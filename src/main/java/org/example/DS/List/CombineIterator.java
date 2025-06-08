package org.example.DS.List;

import java.util.Iterator;

public class CombineIterator<L, R> extends IterableAdapter<Pair<L, R>> {
    private L left;
    private R right;
    private final Iterator<L> iteratorLeft;
    private final Iterator<R> iteratorRight;

    public CombineIterator(Iterator<L> iteratorLeft, Iterator<R> iteratorRight) {
        this.iteratorLeft = iteratorLeft;
        this.iteratorRight = iteratorRight;
    }

    @Override
    public boolean hasNext() {
        return iteratorLeft.hasNext() && iteratorRight.hasNext();
    }

    @Override
    public Pair<L, R> next() {
//        iteratorLeft.hasNext();
        return new Pair<>(iteratorLeft.next(), iteratorRight.next());
    }
}
