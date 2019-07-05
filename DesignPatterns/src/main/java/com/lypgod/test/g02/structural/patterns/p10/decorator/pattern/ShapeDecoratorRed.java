package com.lypgod.test.g02.structural.patterns.p10.decorator.pattern;

/**
 * @author richard
 */
public class ShapeDecoratorRed extends ShapeDecorator {
    public ShapeDecoratorRed(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("Border Color: Red");
    }
}