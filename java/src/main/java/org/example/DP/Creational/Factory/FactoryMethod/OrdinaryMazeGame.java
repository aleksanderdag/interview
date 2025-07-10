package org.example.DP.Creational.Factory.FactoryMethod;

import static org.example.DP.Creational.Factory.FactoryMethod.Room.OrdinaryRoom;

public class OrdinaryMazeGame extends MazeGame {
    @Override
    Room makeRoom() {
        return OrdinaryRoom;
    }
}
