package org.example.DP.Creational.Factory.AbstractFactory;

import static org.example.DP.Creational.Factory.AbstractFactory.MapSite.Wall;

public class MazeFactory { // abstract?
    Maze makeMaze() {
        return new Maze();
    }

    MapSite makeWall() {
        return Wall;
    }

    Room makeRoom(int n) {
        return new Room(n);
    }

    Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
