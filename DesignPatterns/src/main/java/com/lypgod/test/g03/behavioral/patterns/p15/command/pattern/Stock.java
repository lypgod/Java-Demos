package com.lypgod.test.g03.behavioral.patterns.p15.command.pattern;

/**
 * @author richard
 */
class Stock {
    private String name = "ABC";
    private int quantity = 10;

    void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}