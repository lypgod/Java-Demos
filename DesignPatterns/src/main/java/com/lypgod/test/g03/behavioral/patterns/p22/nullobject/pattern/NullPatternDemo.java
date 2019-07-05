package com.lypgod.test.g03.behavioral.patterns.p22.nullobject.pattern;

/**
 * @author richard
 */
public class NullPatternDemo {
    public static void main(String[] args) {
        System.out.println("Customers");
        System.out.println(CustomerFactory.getCustomer("Rob").getName());
        System.out.println(CustomerFactory.getCustomer("Bob").getName());
        System.out.println(CustomerFactory.getCustomer("Julie").getName());
        System.out.println(CustomerFactory.getCustomer("Laura").getName());
    }
}