package com.lypgod.test.g03.behavioral.patterns.p16.interpreter.pattern;

/**
 * @author richard
 */
public interface Expression {
    /**
     * interpret
     *
     * @param context String
     * @return boolean
     */
    boolean interpret(String context);
}