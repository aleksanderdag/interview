package org.example.DS.Node;

import org.example.DS.Collection;

public class NNode<E> {
    E element;
    Collection<E> children;

    public NNode(E element, Collection<E> children) {
        this.element = element;
        this.children = children;
    }
    public NNode(E element) {
        this(element, null);
    }

    void addChild(E element) {
        children.add(element);
    }
}
