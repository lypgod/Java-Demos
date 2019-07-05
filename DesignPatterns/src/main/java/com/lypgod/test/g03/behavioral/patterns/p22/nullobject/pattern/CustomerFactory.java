package com.lypgod.test.g03.behavioral.patterns.p22.nullobject.pattern;

/**
 * @author richard
 */
class CustomerFactory {
    private static final String[] NAMES = {"Rob", "Joe", "Julie"};

    static AbstractCustomer getCustomer(String name) {
        for (String s : NAMES) {
            if (s.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}