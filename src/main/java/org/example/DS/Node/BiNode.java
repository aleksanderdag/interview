package org.example.DS.Node;

public class BiNode<E extends Comparable<E>> implements Node<E> {
    E element;
    BiNode<E>[] children = new BiNode[2]; // TODO: make node

    public BiNode(E element) {
        this.element = element;
    }

    @Override
    public E getElement() {
        return element;
    }

    public BiNode<E> getLeft() {
        return children[0];
    }

    public BiNode<E> getRight() {
        return children[1];
    }

    public void setLeft(BiNode<E> node) {
        children[0] = node;
    }

    public void setRight(BiNode<E> node) {
        children[1] = node;
    }

    public void insert(BiNode<E> node) { // flat node compare; assume it ordered
        if (node.getElement().compareTo(this.getElement()) < 0) {
            if (this.getLeft() == null) {
                this.setLeft(node);
            } else {
                this.getLeft().insert(node);
            }
        } else {
            if (this.getRight() == null) {
                this.setRight(node);
            } else {
                this.getRight().insert(node);
            }
        }
    }

    private void copy(BiNode<E> node) {
        this.setLeft(node.getLeft());
        this.setRight(node.getRight());
    }

    void rotateLeft() {
        BiNode<E> left = this.getLeft();
        BiNode<E> right = this.getRight();
        if (right == null) {
            this.rotateRight();
        } else {
            this.copy(left);
            left.copy(right);

            // right promotion
            right.setLeft(this);
            right.setRight(left);
        }
    }

    void rotateRight() {
        BiNode<E> left = this.getLeft();
        BiNode<E> right = this.getRight();
        if (left == null) {
            this.rotateLeft();
        } else {
            this.copy(right);
            right.copy(left);

            // left promotion
            left.setLeft(right);
            left.setRight(this);
        }
    }

//    private void rotate(BiNode<E> transitiveNode, BiNode<E> newParent) {
//        this.rotateLeft();
//    }

    public void print() {
        this.print(0);
    }

    public void print(int depth) {
        String str = "-".repeat(depth);
        Node<E> left = this.getLeft();
        if(left != null) left.print(depth+1);
        System.out.println(str + this.element);
        Node<E> right = this.getRight();
        if(right != null) right.print(depth+1);
    }

//    public void printValue() {
//        System.out.println(this.element);
//    }
}
