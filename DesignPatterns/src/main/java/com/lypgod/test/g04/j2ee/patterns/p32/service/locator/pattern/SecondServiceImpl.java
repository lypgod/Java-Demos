package com.lypgod.test.g04.j2ee.patterns.p32.service.locator.pattern;

/**
 * @author richard
 */
public class SecondServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Executing SecondServiceImpl");
    }

    @Override
    public String getName() {
        return "SecondServiceImpl";
    }
}