package com.lypgod.test.g03.behavioral.patterns.p14.chain.of.responsibility.pattern;

/**
 * @author richard
 */
public abstract class AbstractLogger {
    static int INFO = 1;
    static int DEBUG = 2;
    static int ERROR = 3;
    int level;

    /**
     * 责任链中的下一个元素
     */
    private AbstractLogger nextLogger;

    void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    /**
     * write
     *
     * @param message String
     */
    abstract protected void write(String message);
}