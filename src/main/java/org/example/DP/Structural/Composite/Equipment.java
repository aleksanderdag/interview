package org.example.DP.Structural.Composite;

public abstract class Equipment {
    private final String name;
    private double price = 0;

    Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double netPrice) {
        this.price = netPrice;
    }

    public double getNetPrice() {
        return price;
    }

    abstract void add(Equipment equipment);
    abstract void remove(Equipment equipment);
}
