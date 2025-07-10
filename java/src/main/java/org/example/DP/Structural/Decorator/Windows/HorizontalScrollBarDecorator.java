package org.example.DP.Structural.Decorator.Windows;

public class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator(Window windowToBeDecorated) {
        super(windowToBeDecorated);
    }

    private void drawHorizontalScrollBat() {
        System.out.println("Drew a horizontal scrollbar");
    }

    @Override
    public void draw() {
        super.draw();
        drawHorizontalScrollBat();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", including horizontal scrollbars";
    }
}
