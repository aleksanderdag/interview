package org.example.DP.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeEquipment extends Equipment {
    List<Equipment> equipment = new ArrayList<>();

    CompositeEquipment(String name) {
        super(name);
    }

    @Override
    public double getNetPrice() {
        return equipment.stream().map(Equipment::getNetPrice).reduce(super.getNetPrice(), Double::sum);
    }

    @Override
    void add(Equipment equipment) {
        this.equipment.add(equipment);
    }

    @Override
    void remove(Equipment equipment) {
        this.equipment.remove(equipment);
    }
}
