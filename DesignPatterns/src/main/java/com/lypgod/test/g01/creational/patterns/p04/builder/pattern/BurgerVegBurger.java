package com.lypgod.test.g01.creational.patterns.p04.builder.pattern;

/**
 * @author richard
 */
public class BurgerVegBurger extends AbstractItemBurger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}