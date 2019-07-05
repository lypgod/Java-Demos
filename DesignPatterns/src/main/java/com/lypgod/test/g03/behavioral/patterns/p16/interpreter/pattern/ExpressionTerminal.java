package com.lypgod.test.g03.behavioral.patterns.p16.interpreter.pattern;

/**
 * @author richard
 */
public class ExpressionTerminal implements Expression {
    private String data;

    ExpressionTerminal(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}