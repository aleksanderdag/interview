package org.example.DP.Creational.Factory.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

import static org.example.DP.Creational.Factory.FactoryMethod.Room.OrdinaryRoom;

// Creator
public abstract class MazeGame {
    private final List<Room> rooms = new ArrayList<>();

    // Creation
    public MazeGame() {
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        room1.connect(room2);
        rooms.add(room1);
        rooms.add(room2);
    }

    // Factory Method
    abstract Room makeRoom();
}
