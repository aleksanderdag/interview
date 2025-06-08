package org.example.DP.Creational.Factory.AbstractFactory;

@FunctionalInterface
public interface MapSite {
    void enter();

    MapSite Wall = () -> System.out.println("Cannot enter wall.");
}
