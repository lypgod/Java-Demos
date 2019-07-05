package com.lypgod.test.g03.behavioral.patterns.p23.strategy.pattern;

/**
 * @author richard
 */
class Context {
    private Operation operation;

    Context(Operation operation) {
        this.operation = operation;
    }

    int executeStrategy(int num1, int num2) {
        return operation.calculate(num1, num2);
    }
}