package com.lypgod.test.g01.creational.patterns.p04.builder.pattern;

/**
 * @author richard
 */
public interface Item {
    /**
     * name
     *
     * @return String
     */
    String name();

    /**
     * packing
     *
     * @return Packing
     */
    Packing packing();

    /**
     * price
     *
     * @return float
     */
    float price();
}