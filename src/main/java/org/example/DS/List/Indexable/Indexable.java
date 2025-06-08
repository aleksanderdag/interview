package org.example.DS.List.Indexable;

import org.example.DS.List.BreakIterator;
import org.example.DS.List.IterableAdapter;
import org.example.DS.List.Pair;
import org.example.DS.List.CombineIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public abstract class Indexable<T> implements Iterable<T> {
    public abstract T get(int index);
    public abstract int size();

    // contains traversal information
    private Iterator<T> iterator = new ForwardIterator();

    public void setIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public @NotNull Iterator<T> iterator() {
        return iterator;
    }

    public class ForwardIterator implements IndexIterator<T> {
        private int index = -1;

        @Override
        public int getIndex() {
            return index;
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return get(++index);
        }
    }

    public class ReverseIterator implements IndexIterator<T> {
        private int index = size();

        @Override
        public int getIndex() {
            return index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            return get(--index);
        }
    }

    public class EntryIterator implements Iterator<Pair<Integer, T>> {
        IndexIterator<T> iterator;

        public EntryIterator(IndexIterator<T> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Pair<Integer, T> next() {
            return new Pair<>(iterator.getIndex(), iterator.next());
        }
    }

    public class OppositeEndsIterable extends IterableAdapter<Pair<T, T>> {
        Iterator<Pair<T, T>> iterator;
        final ForwardIterator forwardIterator = new ForwardIterator();
        final ReverseIterator reverseIterator = new ReverseIterator();
        Iterator<T> iteratorLeft;
        Iterator<T> iteratorRight;

        // Iterator from both sides. stop on index collide.
        public OppositeEndsIterable() {
            iteratorLeft = forwardIterator;
            iteratorRight = reverseIterator;
            this.iterator = new CombineIterator<>(iteratorLeft, iteratorRight);
        }

        public void preventCrossIndex() {
            iterator = new BreakIterator<>(iterator) {
                @Override
                public boolean continueCondition() {
                    // TODO: if iterator gap is larger then 1. this fails.
                    return forwardIterator.getIndex()+1 < reverseIterator.getIndex();
                }
            };
        }

        public Iterator<T> getIteratorLeft() {
            return iteratorLeft;
        }

        private void setIteratorLeft(Iterator<T> iteratorLeft) {
            this.iteratorLeft = iteratorLeft;
        }

        public Iterator<T> getIteratorRight() {
            return iteratorRight;
        }

        private void setIteratorRight(Iterator<T> iteratorRight) {
            this.iteratorRight = iteratorRight;
        }

        public void setIterators(Iterator<T> iteratorLeft, Iterator<T> iteratorRight) {
            setIteratorLeft(iteratorLeft);
            setIteratorRight(iteratorRight);
            this.iterator = new CombineIterator<>(iteratorLeft, iteratorRight);
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Pair<T, T> next() {
            return iterator.next();
        }
    }
}
