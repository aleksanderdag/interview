package org.example.DP.Creational.Factory.FactoryMethod;

// Product
@FunctionalInterface
public interface Room {
    void connect(Room room);

    Room MagicRoom = room -> System.out.println("Magic corridor created.");
    Room OrdinaryRoom = room -> System.out.println("Ordinary corridor created.");
}
