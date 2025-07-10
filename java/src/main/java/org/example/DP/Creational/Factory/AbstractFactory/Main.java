package org.example.DP.Creational.Factory.AbstractFactory;

/**
 * Abstract Factory create a family of related objects.
 * Abstract Factory is a set of Factory Methods.
 * This is used to specify product combinations. [Windows vs Mac || iOS vs Android]
 * In this case, MazeFactory can be inherited to have Doors and MagicRooms.
 * <p>
 * Downgrade: Factory Method - when products have uniform creation [creation logic is shared]
 */
public class Main {
    public static void main(String[] args) {
        MazeGame game = new MazeGame();
        MazeFactory factory = new MazeFactory();
        game.createMaze(factory);
    }
}
