package org.example;

import java.util.function.DoubleSupplier;

public class ManOrBoy {
    public static void main(String[] args) {
        System.out.println(A(15, ()->1, ()->-1, ()->-1, ()->1, ()->0));
    }

    static double A(int k, DoubleSupplier x1, DoubleSupplier x2,
                    DoubleSupplier x3, DoubleSupplier x4, DoubleSupplier x5) {
        DoubleSupplier B = new DoubleSupplier() {
            int m = k;
            @Override
            public double getAsDouble() {
                return A(--m, this, x1, x2, x3, x4);
            }
        };

        return k <= 0 ? x4.getAsDouble() + x5.getAsDouble() : B.getAsDouble();
    }

    static double Ai() {
        while (true) { // A function
            int k = 0; // get from node
            if(k <= 0) {
                // add x4 and x5 to stack
            } else {
                // add B to stack
            }
        }
    }
}
