package org.example.DP.Structural.Composite;

public class FloppyDisk extends Equipment {
    public FloppyDisk(String name) {
        super(name);
    }

    void add(Equipment equipment) {
        throw new RuntimeException("FloppyDisk::add");
    }

    void remove(Equipment equipment) {
        throw new RuntimeException("FloppyDisk::remove");
    }
}
