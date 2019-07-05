package com.lypgod.test.g03.behavioral.patterns.p24.template.pattern;

/**
 * @author richard
 */
class GameFootball implements Game {

    @Override
    public void initialize() {
        System.out.println("GameFootball Game Initialized! Start playing.");
    }

    @Override
    public void startPlay() {
        System.out.println("GameFootball Game Started. Enjoy the game!");
    }

    @Override
    public void endPlay() {
        System.out.println("GameFootball Game Finished!");
    }
}