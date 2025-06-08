package org.example.DS.Tree;

import org.example.DS.Node.BiNode;
import org.example.DS.Node.Node;

public class BinaryTree<E extends Comparable<E>> implements Tree<E> { // BiNode manager
    BiNode<E> root;

    public void insert(E element) {
        BiNode<E> node = new BiNode<>(element); // TODO: make node method
//        BiNode<E> current = root;

//        while (current != null) { // TODO: make iterator?
////            if (node.element.compareTo(current.element) < 0) {
////                current = (BiNode<E>) current.getLeft();
////            } else {
////                current = (BiNode<E>) current.getRight(); // TODO: move generic
////            }
//        }

        if(root != null) {
            root.insert(node);
        } else {
            root = node;
        }

        balance();
    }

    public void balance() {}

    public void print() {
        print(root);
    }

    private void print(Node<E> node) {
        if (node == null) {
            return;
        }
        node.print();
    }
}
