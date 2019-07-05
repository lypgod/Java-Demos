package com.lypgod.test.g01.creational.patterns.p05.prototype.pattern;

import java.util.Hashtable;

/**
 * @author richard
 */
class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return cachedShape.clone();
    }

    static void loadCache() {
        ShapeCircle circle = new ShapeCircle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        ShapeSquare square = new ShapeSquare();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        ShapeRectangle rectangle = new ShapeRectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}