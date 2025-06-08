package org.example.DP.Creational.Factory.SimpleFactory;

public class ExhaustFan implements IFan {
    @Override
    public void switchOn() {
        System.out.println("Switching exhaust fan on.");
    }

    @Override
    public void switchOff() {
        System.out.println("Switching exhaust fan off.");
    }
}
