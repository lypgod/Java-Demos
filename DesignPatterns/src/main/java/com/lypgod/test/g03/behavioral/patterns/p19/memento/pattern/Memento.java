package com.lypgod.test.g03.behavioral.patterns.p19.memento.pattern;

/**
 * @author richard
 */
public class Memento {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento(String state) {
        this.state = state;
    }
}