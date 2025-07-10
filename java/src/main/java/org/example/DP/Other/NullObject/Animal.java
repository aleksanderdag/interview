package org.example.DP.Other.NullObject;

@FunctionalInterface
public interface Animal {
    void makeSound();

    Animal Dog = () -> System.out.println("woof!");
    Animal NullAnimal = () -> {};
}
