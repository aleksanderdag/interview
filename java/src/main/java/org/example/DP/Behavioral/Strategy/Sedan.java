package org.example.DP.Behavioral.Strategy;

import static org.example.DP.Behavioral.Strategy.IBrakeBehavior.Brake;

public class Sedan extends Car {
    public Sedan() {
        super(Brake);
    }
}
