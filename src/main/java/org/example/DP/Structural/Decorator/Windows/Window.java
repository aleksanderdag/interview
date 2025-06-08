package org.example.DP.Structural.Decorator.Windows;

public interface Window {
    void draw();
    String getDescription();

    Window SimpleWindow = new Window() {
        @Override
        public void draw() {
            System.out.println("Drew to window.");
        }

        @Override
        public String getDescription() {
            return "simple window";
        }
    };
}
