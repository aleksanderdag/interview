package org.example.DP.Structural.Flyweight;

// extrinsic data blueprint
public record MyObject(String name) {
    public String company() {
        return Pointer.COMPANY.name();
    }
}
