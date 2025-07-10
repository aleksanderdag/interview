package org.example.DP.Creational.Factory.AbstractFactory;

public record Room(int roomNumber) implements MapSite {
    @Override
    public void enter() {
        System.out.println("Entering room.");
    }

    void setSide(Direction d, MapSite ms) {
        System.out.println("Room::setSide: " + d + " on " + ms);
    }
}
