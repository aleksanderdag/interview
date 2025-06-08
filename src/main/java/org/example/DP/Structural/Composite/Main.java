package org.example.DP.Structural.Composite;

/**
 * <p>
 * The goal of Composite Pattern is to treat all components equally
 * by treating simple components as aggregate components [composite].
 * To avoid specialized leaf logic, NullObject pattern can be used, so:
 * FloppyDisk extends CompositeEquipment, but its List is always empty,
 * then roll Equipment into CompositeEquipment.
 * Composite with List.length == 1 is like Decorator.
 * The difference is that Decor implements have unique logic before pass through,
 * [this can be avoided by imp pass through method in Composite components]
 * and decorators REQUIRE 1 and only 1 simple class in constructor. [exactly 1 guaranteed]
 * <p>
 * Largest issue with this pattern is that the traversal is not separated from the composite logic.
 * This pattern can be combined with Iterator pattern to solve this issue.
 * <p>
 * If a composite component is used in multiple other composites, a DAG is made.
 * This might become cyclical, but this is a concern even in flat composite.
 */
public class Main {
    public static void main(String[] args) {
        FloppyDisk fd1 = new FloppyDisk("3.5in Floppy");
        fd1.setPrice(19.99);
        printPrice(fd1);

        FloppyDisk fd2 = new FloppyDisk("5.25in Floppy");
        fd2.setPrice(29.99);
        printPrice(fd2);

        Chassis ch = new Chassis("PC Chasis");
        ch.setPrice(39.99);
        ch.add(fd1);
        ch.add(fd2);
        printPrice(ch);
        ch.remove(fd2);
        printPrice(ch);

//        fd2.add(fd1);
    }

    public static void printPrice(Equipment equipment) {
        System.out.println(equipment.getName() + ": netPrice=" + equipment.getNetPrice());
    }
}
