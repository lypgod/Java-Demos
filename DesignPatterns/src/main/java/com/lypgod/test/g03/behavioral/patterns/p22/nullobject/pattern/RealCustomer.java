package com.lypgod.test.g03.behavioral.patterns.p22.nullobject.pattern;

/**
 * @author richard
 */
public class RealCustomer extends AbstractCustomer {
    RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}