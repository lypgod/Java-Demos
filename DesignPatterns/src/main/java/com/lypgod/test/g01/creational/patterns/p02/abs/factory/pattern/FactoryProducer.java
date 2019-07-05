package com.lypgod.test.g01.creational.patterns.p02.abs.factory.pattern;

/**
 * @author richard
 */
class FactoryProducer {
    private static final String FACTORY_SHAPE = "SHAPE";
    private static final String FACTORY_COLOR = "COLOR";

    static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase(FACTORY_SHAPE)) {
            return new ShapeFactory();
        }

        if (choice.equalsIgnoreCase(FACTORY_COLOR)) {
            return new ColorFactory();
        }

        return null;
    }
}