package org.example.DP.Structural.Adapter;

public record LightningToMicroUsbAdapter(ILightningPhone lightningPhone) implements IMicroUsbPhone {
    @Override
    public void useMicroUsb() {
        System.out.println("MicroUsb connected");
        lightningPhone.useLightning();
    }

    @Override
    public void recharge() {
        lightningPhone.recharge();
    }
}
