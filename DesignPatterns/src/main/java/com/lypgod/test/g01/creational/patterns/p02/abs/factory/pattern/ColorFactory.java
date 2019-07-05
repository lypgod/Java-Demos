package com.lypgod.test.g01.creational.patterns.p02.abs.factory.pattern;

/**
 * @author richard
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        throw new RuntimeException("Cannot get shape");
    }

    @Override
    public Color getColor(String color) {
        if (color.equalsIgnoreCase(Color.COLOR_RED)) {
            return new ColorRed();
        }

        if (color.equalsIgnoreCase(Color.COLOR_GREEN)) {
            return new ColorGreen();
        }

        if (color.equalsIgnoreCase(Color.COLOR_BLUE)) {
            return new ColorBlue();
        }

        throw new RuntimeException("Color not found");
    }
}