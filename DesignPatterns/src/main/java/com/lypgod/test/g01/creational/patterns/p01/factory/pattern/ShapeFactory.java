package com.lypgod.test.g01.creational.patterns.p01.factory.pattern;

class ShapeFactory {

    Shape getShape(String shapeType) {
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
}