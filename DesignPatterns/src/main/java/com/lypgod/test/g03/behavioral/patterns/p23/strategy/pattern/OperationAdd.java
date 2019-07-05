package com.lypgod.test.g03.behavioral.patterns.p23.strategy.pattern;

/**
 * @author richard
 */
public class OperationAdd implements Operation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}