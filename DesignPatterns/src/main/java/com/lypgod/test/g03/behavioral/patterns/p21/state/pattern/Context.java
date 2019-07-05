package com.lypgod.test.g03.behavioral.patterns.p21.state.pattern;

/**
 * @author richard
 */
class Context {
    private State state;

    Context() {
        this.state = null;
    }

    void setState(State state) {
        this.state = state;
    }

    State getState() {
        return this.state;
    }
}