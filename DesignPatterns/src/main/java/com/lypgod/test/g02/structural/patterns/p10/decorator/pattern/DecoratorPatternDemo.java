package com.lypgod.test.g02.structural.patterns.p10.decorator.pattern;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new ShapeCircle();

        Shape redCircle = new ShapeDecoratorRed(new ShapeCircle());

        Shape redRectangle = new ShapeDecoratorRed(new ShapeRectangle());
        System.out.println("ShapeCircle with normal border");
        circle.draw();

        System.out.println("\nShapeCircle of red border");
        redCircle.draw();

        System.out.println("\nShapeRectangle of red border");
        redRectangle.draw();
    }
}