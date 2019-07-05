package com.lypgod.test.g03.behavioral.patterns.p20.observer.pattern;

/**
 * @author richard
 */
public class HexaObserver extends AbstractObserver {
    HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}