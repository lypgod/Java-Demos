package com.lypgod.test.g01.creational.patterns.p05.prototype.pattern;

/**
 * @author richard
 */
public class ShapeCircle extends Shape {
    public ShapeCircle() {
        this.setType("ShapeCircle");
    }

    @Override
    public void draw() {
        System.out.println("Inside ShapeCircle::draw() method.");
    }
}