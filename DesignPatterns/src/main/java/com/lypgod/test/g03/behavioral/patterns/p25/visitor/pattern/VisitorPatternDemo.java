package com.lypgod.test.g03.behavioral.patterns.p25.visitor.pattern;

/**
 * @author richard
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        new ComputerPartComputer().accept(new ComputerPartVisitorImpl());
    }
}