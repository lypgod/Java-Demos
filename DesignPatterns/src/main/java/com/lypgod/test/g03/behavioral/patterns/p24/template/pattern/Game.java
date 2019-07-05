package com.lypgod.test.g03.behavioral.patterns.p24.template.pattern;

/**
 * @author richard
 */
interface Game {
    /**
     * initialize
     */
    void initialize();

    /**
     * startPlay
     */
    void startPlay();

    /**
     * endPlay
     */
    void endPlay();

    /**
     * template
     */
    default void play() {
        initialize();
        startPlay();
        endPlay();
    }
}