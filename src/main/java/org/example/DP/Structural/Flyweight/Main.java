package org.example.DP.Structural.Flyweight;

/**
 * All intrinsic data should be invariant, context-independent, and sharable.
 * In this case, just store it in a record container.
 * Combine this with factory methods to allow for return of existing
 * flyweight objects [intrinsic data] for minimized data.
 * <p>
 * Flyweight - intrinsic data blueprint
 * Pointer - intrinsic data objects container
 * MyObject - extrinsic data blueprint
 */
public class Main {
    public static void main(String[] args) {
        MyObject alek = new MyObject("Alek");
        System.out.println(alek.company());
    }
}
