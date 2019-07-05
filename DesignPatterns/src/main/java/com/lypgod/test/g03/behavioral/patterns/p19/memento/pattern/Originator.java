package com.lypgod.test.g03.behavioral.patterns.p19.memento.pattern;

/**
 * @author richard
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    Memento saveStateToMemento() {
        return new Memento(state);
    }

    void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}