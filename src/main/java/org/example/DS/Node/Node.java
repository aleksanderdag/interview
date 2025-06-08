package org.example.DS.Node;

public interface Node<E> {
    E getElement();
//    abstract void insert(Node<E> node);
    void print();
    void print(int depth);
}
