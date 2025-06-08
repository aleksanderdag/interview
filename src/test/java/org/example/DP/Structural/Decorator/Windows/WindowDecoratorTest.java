package org.example.DP.Structural.Decorator.Windows;

import org.junit.jupiter.api.Test;

import static org.example.DP.Structural.Decorator.Windows.Window.SimpleWindow;
import static org.junit.jupiter.api.Assertions.*;

class WindowDecoratorTest {

    @Test
    void testWindowDecoratorTest() {
        Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(SimpleWindow));
        assertEquals("simple window, including vertical scrollbars, including horizontal scrollbars",
                decoratedWindow.getDescription());
    }
}