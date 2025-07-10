package org.example.DP.Creational.Factory.FactoryMethod;

/**
 * A Factory produces objects [or similar effect].
 * A creation method is strictly for objects creation [constructor wrapper].
 * <p>
 * All Factory patterns determine which object type will be used.
 * A Simple Factory does this over an enum or case switch [See Simple Factory] with a single creator for all products.
 * A Factory Method is a creation method that defers creation logic to child creators.
 * An Abstract Factory creates a family of related objects [See Abstract Factory].
 * <p>
 * Factory Method determines which object type will be made by deferred abstract method, and
 * the post-creation logic is in the factory constructor.
 * This separates the post-creation logic [in abstract creator] from the selection logic [inheritance].
 * <p>
 * Factory Method container classes are called creators, and their creations are called products.
 * Creators will be abstract to force factory method implementation.
 * <p>
 * Downgrade: Simple Factory - when products have uniform pre-production [param set up]
 * Upgrade: Abstract Factory - when products have unique creation [no shared creation logic], but require coupling
 */
public class Main {
    public static void main(String[] args) {
        new OrdinaryMazeGame();
        new MagicMazeGame();
    }
}
