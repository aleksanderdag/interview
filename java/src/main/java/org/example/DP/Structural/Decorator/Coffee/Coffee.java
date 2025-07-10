package org.example.DP.Structural.Decorator.Coffee;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Coffee {
    double getCost();
    String getIngredients();

    Coffee SimpleCoffee = new Coffee() {
        @Override
        public double getCost() {
            return 1;
        }

        @Override
        public String getIngredients() {
            return "Coffee";
        }
    };
}
