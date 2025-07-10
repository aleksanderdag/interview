package org.example.DP.Behavioral.Memento;

public class Originator {
    private String state;

    public void set(String state) {
        this.state = state;
        System.out.println("Originator: Saving to Memento.");
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.state();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}
