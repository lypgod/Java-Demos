package com.lypgod.test.g03.behavioral.patterns.p20.observer.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
class Subject {
    private List<AbstractObserver> observers = new ArrayList<>();
    private int state;

    int getState() {
        return this.state;
    }

    void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    void addObserver(AbstractObserver observer) {
        this.observers.add(observer);
    }

    private void notifyAllObservers() {
        observers.forEach(AbstractObserver::update);
    }
}