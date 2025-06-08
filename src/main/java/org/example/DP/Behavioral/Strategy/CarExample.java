package org.example.DP.Behavioral.Strategy;

import static org.example.DP.Behavioral.Strategy.IBrakeBehavior.Brake;

/*
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
