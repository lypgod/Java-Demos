package com.lypgod.test.g03.behavioral.patterns.p20.observer.pattern;

/**
 * @author richard
 */
public class BinaryObserver extends AbstractObserver {
    BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}