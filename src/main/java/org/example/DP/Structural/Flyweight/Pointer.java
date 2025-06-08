package org.example.DP.Structural.Flyweight;

// intrinsic data object container
public record Pointer() {
    public static final Flyweight COMPANY = new Flyweight("Abc", "XYZ", "www.example.com");
}
