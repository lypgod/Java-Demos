package com.lypgod.test.g01.creational.patterns.p04.builder.pattern;

/**
 * @author richard
 */
public abstract class AbstractItemBurger implements Item {
    @Override
    public Packing packing() {
        return new PackingWrapper();
    }

    /**
     * price
     *
     * @return float
     */
    @Override
    public abstract float price();
}