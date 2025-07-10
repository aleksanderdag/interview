package org.example.DP.Structural.Decorator.Windows;

import static org.example.DP.Structural.Decorator.Windows.Window.SimpleWindow;

public class DecoratedWindowTest {
    public static void main(String[] args) {
        Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(SimpleWindow));
        System.out.println(decoratedWindow.getDescription());
    }
}
