package com.lypgod.test.g02.structural.patterns.p11.facade.pattern;

public class ShapeFacade {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeFacade() {
        this.circle = new ShapeCircle();
        this.rectangle = new ShapeRectangle();
        this.square = new ShapeSquare();
    }

    public void drawCircle() {
        this.circle.draw();
    }

    public void drawRectangle() {
        this.rectangle.draw();
    }

    public void drawSquare() {
        this.square.draw();
    }
}