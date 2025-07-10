package org.example.DP.Behavioral.Strategy;

import static org.example.DP.Behavioral.Strategy.IBrakeBehavior.Brake;

/**
 * Context(IBehavior).behave() {behavior.behave();}
 * <p>
 *     A strategy is a class that has an interface object which can be set at runtime.
 * </p>
 * <p>
 *     The Strategy pattern is when a class (the context) has a field of interface type,
 *     and the concrete implementation of that interface can be set or changed at runtime,
 *     so that the class's behavior changes by delegation.
 * </p>
 * <p>
 * The concept is that the similar classes have modular functionality via lambdas.
 * Parts of the class are plug and play with pre-defined functions.
 * If functionality is unlimited to input, you now have functional programming.
 */
public class CarExample {
    public static void main(final String[] args) {
        Car sedanCar = new Sedan();
        sedanCar.applyBrake();

        Car suvCar = new SUV();
        suvCar.applyBrake();

        suvCar.setBrakeBehavior(Brake);
        suvCar.applyBrake();
    }
}
