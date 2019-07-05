package com.lypgod.test.g02.structural.patterns.p07.bridge.pattern;

/**
 * @author richard
 */
public class DrawRedCircle implements DrawCircle {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}