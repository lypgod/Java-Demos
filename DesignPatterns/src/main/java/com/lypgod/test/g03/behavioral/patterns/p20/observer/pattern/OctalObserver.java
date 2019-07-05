package com.lypgod.test.g03.behavioral.patterns.p20.observer.pattern;

/**
 * @author richard
 */
public class OctalObserver extends AbstractObserver {
    OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}