package com.lypgod.test.g01.creational.patterns.p02.abs.factory.pattern;

/**
 * @author richard
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase(Shape.SHAPE_CIRCLE)) {
            return new ShapeCircle();
        }

        if (shapeType.equalsIgnoreCase(Shape.SHAPE_RECTANGLE)) {
            return new ShapeRectangle();
        }

        if (shapeType.equalsIgnoreCase(Shape.SHAPE_SQUARE)) {
            return new ShapeSquare();
        }

        throw new RuntimeException("AbstractShape not found");
    }

    @Override
    public Color getColor(String color) {
        throw new RuntimeException("Cannot get color");
    }
}