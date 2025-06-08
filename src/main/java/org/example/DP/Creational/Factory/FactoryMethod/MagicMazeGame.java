package org.example.DP.Creational.Factory.FactoryMethod;

import static org.example.DP.Creational.Factory.FactoryMethod.Room.MagicRoom;

public class MagicMazeGame extends MazeGame {
    @Override
    Room makeRoom() {
        return MagicRoom;
    }
}
