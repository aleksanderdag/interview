package org.example.DP.Other.NullObject;

import static org.example.DP.Other.NullObject.Animal.Dog;
import static org.example.DP.Other.NullObject.Animal.NullAnimal;

/*
 * Avoids using null checking if statements.
 */
public class Main {
    public static void main(String[] args) {
        Animal favAnimal = NullAnimal;
        favAnimal.makeSound();
        favAnimal = Dog;
        favAnimal.makeSound();
    }
}
