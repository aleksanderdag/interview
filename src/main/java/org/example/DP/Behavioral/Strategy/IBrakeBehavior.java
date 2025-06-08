package org.example.DP.Behavioral.Strategy;

@FunctionalInterface
public interface IBrakeBehavior {
    void brake();

    IBrakeBehavior Brake = () -> System.out.println("Simple Brake applied.");
    IBrakeBehavior BrakeWithABS = () -> System.out.println("Brake with ABS applied.");
}
