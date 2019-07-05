package com.lypgod.test.g04.j2ee.patterns.p32.service.locator.pattern;

/**
 * @author richard
 */
class InitialContext {
    Object lookup(String jndiName) {
        if (jndiName.equalsIgnoreCase("SERVICE1")) {
            System.out.println("Looking up and creating a new FirstServiceImpl object");
            return new FirstServiceImpl();
        }

        if (jndiName.equalsIgnoreCase("SERVICE2")) {
            System.out.println("Looking up and creating a new SecondServiceImpl object");
            return new SecondServiceImpl();
        }

        return null;
    }
}