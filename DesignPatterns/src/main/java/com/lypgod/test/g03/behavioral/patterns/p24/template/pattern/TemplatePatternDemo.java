package com.lypgod.test.g03.behavioral.patterns.p24.template.pattern;

/**
 * @author richard
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        new GameCricket().play();
        System.out.println();
        new GameFootball().play();
    }
}