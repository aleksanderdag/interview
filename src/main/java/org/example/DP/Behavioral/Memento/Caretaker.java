package org.example.DP.Behavioral.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento holds Originator state record.
 * In this case, Originator can create or restore from Memento objects, and
 * Caretaker maintains the list of Mementos objects.
 */
public class Caretaker {
    public static void main(String[] args) {
        List<Memento> savedStates = new ArrayList<>();
        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());
        originator.set("State3");
        savedStates.add(originator.saveToMemento());
        originator.set("State4");
        originator.restoreFromMemento(savedStates.get(1));
    }
}
