package com.lypgod.test.g03.behavioral.patterns.p18.mediator.pattern;

/**
 * @author richard
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}