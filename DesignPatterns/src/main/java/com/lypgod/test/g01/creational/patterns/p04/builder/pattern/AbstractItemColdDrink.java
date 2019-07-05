package com.lypgod.test.g01.creational.patterns.p04.builder.pattern;

/**
 * @author richard
 */
public abstract class AbstractItemColdDrink implements Item {
    @Override
    public Packing packing() {
        return new PackingBottle();
    }

    /**
     * price
     *
     * @return float
     */
    @Override
    public abstract float price();
}