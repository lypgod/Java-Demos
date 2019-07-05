package com.lypgod.test.g04.j2ee.patterns.p32.service.locator.pattern;

/**
 * @author richard
 */
public class ServiceLocatorPatternDemo {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("FirstServiceImpl");
        service.execute();
        service = ServiceLocator.getService("SecondServiceImpl");
        service.execute();
        service = ServiceLocator.getService("FirstServiceImpl");
        service.execute();
        service = ServiceLocator.getService("SecondServiceImpl");
        service.execute();
    }
}