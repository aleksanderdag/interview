package org.example.DS;

import org.example.DS.List.*;
import org.example.DS.List.Indexable.IndexableCharSequence;

public class Main {
    public static void main(String[] args) {
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        bt.insert(5);
//        bt.insert(7);
//        bt.insert(4);
//        bt.insert(0);
//        bt.insert(44);
//        bt.insert(55);
//        bt.insert(46);
////        bt.add(0);bt.add(0);bt.add(0);bt.add(0);bt.add(0);bt.add(0);
//        bt.print();

        var collection = new IndexableCharSequence("i am alek");
        var iter = collection.new ForwardIterator();
        var revI = collection.new ReverseIterator();
        var myIter = new CombineIterator<>(iter, revI);
//        items.setIterator(myIter);
//        for(Character item : items) {
//            System.out.println(item);
//        }

        for (var elem : myIter) {
            System.out.println(elem);
//            elem.left() == elem.left();
        }
    }
}
