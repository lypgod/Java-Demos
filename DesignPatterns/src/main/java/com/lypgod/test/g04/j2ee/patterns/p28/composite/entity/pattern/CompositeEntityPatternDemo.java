package com.lypgod.test.g04.j2ee.patterns.p28.composite.entity.pattern;

/**
 * @author richard
 */
public class CompositeEntityPatternDemo {
    public static void main(String[] args) {
        Client client = new Client();
        client.setData("Test", "Data");
        client.printData();
        client.setData("Second Test", "Data1");
        client.printData();
    }
}