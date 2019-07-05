package com.lypgod.test.g02.structural.patterns.p12.flyweight.pattern;

/**
 * @author richard
 */
public class ShapeCircle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public ShapeCircle(String color) {
        this.color = color;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("ShapeCircle: Draw() [Color: " + color
                + ", x: " + x
                + ", y: " + y
                + ", radius:" + radius
                + "]");
    }
}