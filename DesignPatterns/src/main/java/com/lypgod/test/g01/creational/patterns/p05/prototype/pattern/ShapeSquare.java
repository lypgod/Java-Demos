package com.lypgod.test.g01.creational.patterns.p05.prototype.pattern;

/**
 * @author richard
 */
public class ShapeSquare extends Shape {
    public ShapeSquare() {
        this.setType("ShapeSquare");
    }

    @Override
    public void draw() {
        System.out.println("Inside ShapeSquare::draw() method.");
    }
}