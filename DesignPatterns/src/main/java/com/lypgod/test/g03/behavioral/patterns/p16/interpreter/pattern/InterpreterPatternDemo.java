package com.lypgod.test.g03.behavioral.patterns.p16.interpreter.pattern;

/**
 * @author richard
 */
public class InterpreterPatternDemo {
    /**
     * 规则：Robert 和 John 是男性
     */
    private static Expression getMaleExpression() {
        Expression robert = new ExpressionTerminal("Robert");
        Expression john = new ExpressionTerminal("John");
        return new ExpressionOr(robert, john);
    }

    /**
     * 规则：Julie 是一个已婚的女性
     */
    private static Expression getMarriedWomanExpression() {
        Expression julie = new ExpressionTerminal("Julie");
        Expression married = new ExpressionTerminal("Married");
        return new ExpressionAnd(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
    }
}