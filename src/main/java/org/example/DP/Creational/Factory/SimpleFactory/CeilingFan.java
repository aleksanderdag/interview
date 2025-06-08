package org.example.DP.Creational.Factory.SimpleFactory;

public class CeilingFan implements IFan {
    @Override
    public void switchOn() {
        System.out.println("Switching ceiling fan on.");
    }

    @Override
    public void switchOff() {
        System.out.println("Switching ceiling fan off.");
    }
}
