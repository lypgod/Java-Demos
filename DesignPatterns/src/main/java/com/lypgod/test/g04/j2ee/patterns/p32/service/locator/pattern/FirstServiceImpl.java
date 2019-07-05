package com.lypgod.test.g04.j2ee.patterns.p32.service.locator.pattern;

/**
 * @author richard
 */
public class FirstServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Executing FirstServiceImpl");
    }

    @Override
    public String getName() {
        return "FirstServiceImpl";
    }
}