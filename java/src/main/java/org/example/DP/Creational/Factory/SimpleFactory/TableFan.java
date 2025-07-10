package org.example.DP.Creational.Factory.SimpleFactory;

public class TableFan implements IFan {
    @Override
    public void switchOn() {
        System.out.println("Switching table fan on.");
    }

    @Override
    public void switchOff() {
        System.out.println("Switching table fan of..");
    }
}
