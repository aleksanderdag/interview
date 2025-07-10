package org.example.DP.Structural.Adapter;

public interface ILightningPhone {
    void recharge();
    void useLightning();

    ILightningPhone iPhone = new ILightningPhone() {
        private boolean connector;

        @Override
        public void useLightning() {
            connector = true;
            System.out.println("Lightning connected");
        }

        @Override
        public void recharge() {
            if(connector) {
                System.out.println("Recharge started");
                System.out.println("Recharge finished");
            } else {
                System.out.println("Connect Lightning first");
            }
        }
    };


}
