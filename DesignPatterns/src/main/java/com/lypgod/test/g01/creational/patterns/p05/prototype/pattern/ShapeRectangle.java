package com.lypgod.test.g01.creational.patterns.p05.prototype.pattern;

/**
 * @author richard
 */
public class ShapeRectangle extends Shape {
    public ShapeRectangle() {
        this.setType("ShapeRectangle");
    }

    @Override
    public void draw() {
        System.out.println("Inside ShapeRectangle::draw() method.");
    }
}