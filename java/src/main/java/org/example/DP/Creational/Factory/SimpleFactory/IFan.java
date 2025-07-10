package org.example.DP.Creational.Factory.SimpleFactory;

public interface IFan {
    void switchOn();
    void switchOff();

    IFan cf = new IFan() {
        @Override
        public void switchOn() {
            System.out.println("Switching ceiling fan on.");
        }

        @Override
        public void switchOff() {
            System.out.println("Switching ceiling fan off.");
        }
    };

    IFan jf = new IFan() {
        @Override
        public void switchOn() {
            System.out.println("Switching jimmy fan on.");
        }

        @Override
        public void switchOff() {
            System.out.println("Switching jimmy fan off.");
        }
    };
}
