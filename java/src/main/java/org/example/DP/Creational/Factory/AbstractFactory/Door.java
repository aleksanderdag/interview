package org.example.DP.Creational.Factory.AbstractFactory;

public record Door(Room room1, Room room2) implements MapSite {
    @Override
    public void enter() {
        System.out.println("Entering a door.");
    }
}
