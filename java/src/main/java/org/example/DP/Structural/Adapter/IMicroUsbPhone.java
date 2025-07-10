package org.example.DP.Structural.Adapter;

public interface IMicroUsbPhone {
    void recharge();
    void useMicroUsb();

    IMicroUsbPhone android = new IMicroUsbPhone() {
        private boolean connector;

        @Override
        public void useMicroUsb() {
            connector = true;
            System.out.println("MicroUsb connected");
        }

        @Override
        public void recharge() {
            if (connector) {
                System.out.println("Recharge started");
                System.out.println("Recharge finished");
            } else {
                System.out.println("Connect MicroUsb first");
            }
        }
    };
}
