package com.lypgod.test.g03.behavioral.patterns.p21.state.pattern;

/**
 * @author richard
 */
public class StateStart implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}