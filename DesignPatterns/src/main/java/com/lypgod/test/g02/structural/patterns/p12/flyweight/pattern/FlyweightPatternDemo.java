package com.lypgod.test.g02.structural.patterns.p12.flyweight.pattern;

import java.util.Random;

public class FlyweightPatternDemo {
    private static Random random = new Random();
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {

        for (int i = 0; i < 20; ++i) {
            ShapeCircle circle = (ShapeCircle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return random.nextInt(100);
    }

    private static int getRandomY() {
        return random.nextInt(100);
    }
}