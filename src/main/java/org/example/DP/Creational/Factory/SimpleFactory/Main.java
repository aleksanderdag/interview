package org.example.DP.Creational.Factory.SimpleFactory;

import static org.example.DP.Creational.Factory.SimpleFactory.IFanFactory.FanFactory;

/**
 * Simple Factory uses an enum [or switch] to determine which class is to be made.
 * There is a single creator for all products. [Many product classes to one creator class]
 * <p>
 * Upgrade: Factory Method - when pre-production logic is unique per product [param set-up]
 */
public class Main {
    public static void main(String[] args) {
        IFan fan = FanFactory.createFan(FanType.TABLE_FAN);
        fan.switchOn();
        IFan eFan = FanFactory.createFan(FanType.EXHAUST_FAN);
        eFan.switchOff();
        System.out.println(eFan.getClass());
        IFan cFan = FanFactory.createFan(FanType.CEILING_FAN);
        cFan.switchOff();
        System.out.println(cFan.getClass());
    }
}
