package com.lypgod.test.g03.behavioral.patterns.p14.chain.of.responsibility.pattern;

/**
 * @author richard
 */
public class FileLogger extends AbstractLogger {
    FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}