package com.lypgod.test.g03.behavioral.patterns.p14.chain.of.responsibility.pattern;

/**
 * @author richard
 */
public class ConsoleLogger extends AbstractLogger {
    ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}