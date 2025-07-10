package org.example.DP.Behavioral.Strategy;

import static org.example.DP.Behavioral.Strategy.IBrakeBehavior.BrakeWithABS;

public class SUV extends Car {
    public SUV() {
        super(BrakeWithABS);
    }
}
