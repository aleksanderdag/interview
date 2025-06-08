package org.example.DS.Node;

import org.example.DS.Color;

public class ColorNode<E extends Comparable<E>> extends BiNode<E> {
    private Color color;
    private ColorNode<E> parent;

    public ColorNode(E element) {
        super(element);
    }
}
