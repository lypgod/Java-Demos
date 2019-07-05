package com.lypgod.test.g03.behavioral.patterns.p21.state.pattern;

/**
 * @author richard
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StateStart stateStart = new StateStart();
        stateStart.doAction(context);

        System.out.println(context.getState().toString());

        StateStop stateStop = new StateStop();
        stateStop.doAction(context);

        System.out.println(context.getState().toString());
    }
}