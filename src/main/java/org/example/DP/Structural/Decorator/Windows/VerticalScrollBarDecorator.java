package org.example.DP.Structural.Decorator.Windows;

public class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator (Window windowToBeDecorated) {
        super(windowToBeDecorated);
    }

    private void drawVerticalScrollBar() {
        System.out.println("Drew a vertical scrollbar");
    }

    @Override
    public void draw() {
        super.draw();
        drawVerticalScrollBar();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", including vertical scrollbars";
    }
}
