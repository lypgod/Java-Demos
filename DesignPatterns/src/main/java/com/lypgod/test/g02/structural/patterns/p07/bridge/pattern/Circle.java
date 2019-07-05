package com.lypgod.test.g02.structural.patterns.p07.bridge.pattern;

/**
 * @author richard
 */
public class Circle extends AbstractShape {
    private int x, y, radius;

    Circle(int x, int y, int radius, DrawCircle drawCircle) {
        super(drawCircle);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawCircle.drawCircle(radius, x, y);
    }
}