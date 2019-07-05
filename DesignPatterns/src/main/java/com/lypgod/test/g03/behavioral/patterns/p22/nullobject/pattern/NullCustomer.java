package com.lypgod.test.g03.behavioral.patterns.p22.nullobject.pattern;

/**
 * @author richard
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}