package org.example.DP.Structural.Adapter;

import static org.example.DP.Structural.Adapter.ILightningPhone.iPhone;
import static org.example.DP.Structural.Adapter.IMicroUsbPhone.android;

/**
 * Adapter consumes source interface and implements client interface [sometimes called a wrapper].
 * This adapter converts interfaces via composition, but this can also be achieved via multi-inheritance.
 * <p>
 * Avoid this pattern by sharing the same interface when possible.
 * NOTE: This is another way of versioning without augmentations.
 */
public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("Recharging android with MicroUsb");
        rechargeMicroUsbPhone(android);

        System.out.println("Recharging iPhone with Lightning");
        rechargeLightningPhone(iPhone);

        System.out.println("Recharging iPhone with MicroUsb");
        rechargeMicroUsbPhone(new LightningToMicroUsbAdapter(iPhone));
    }

    static void rechargeMicroUsbPhone(IMicroUsbPhone phone) {
        phone.useMicroUsb();
        phone.recharge();
    }

    static void rechargeLightningPhone(ILightningPhone phone) {
        phone.useLightning();
        phone.recharge();
    }
}
