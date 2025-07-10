package org.example.DP.Creational.Factory.AbstractFactory;

public class Maze {
    void addRoom(Room r) {
        System.out.println("Maze::addRoom: " + r);
    }

    Room roomNo(int n) {
        return null;
    }
}
