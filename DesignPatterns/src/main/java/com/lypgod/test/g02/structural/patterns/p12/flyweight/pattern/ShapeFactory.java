package com.lypgod.test.g02.structural.patterns.p12.flyweight.pattern;

import java.util.HashMap;
import java.util.Optional;

public class ShapeFactory {
    private static final HashMap<String, Shape> CIRCLE_MAP = new HashMap<>();

    public static Shape getCircle(String color) {
        return Optional.ofNullable(CIRCLE_MAP.get(color)).orElseGet(() -> {
            ShapeCircle circle = new ShapeCircle(color);
            CIRCLE_MAP.put(color, circle);
            System.out.println("Creating circle of color : " + color);
            return circle;
        });
    }
}