package com.lypgod.test.g01.creational.patterns.p02.abs.factory.pattern;

/**
 * @author richard
 */
public class ColorRed implements Color {
    @Override
    public void fill() {
        System.out.println("Inside ColorRed::fill() method.");
    }
}