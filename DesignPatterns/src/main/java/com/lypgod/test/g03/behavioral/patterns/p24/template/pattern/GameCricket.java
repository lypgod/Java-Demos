package com.lypgod.test.g03.behavioral.patterns.p24.template.pattern;

/**
 * @author richard
 */
public class GameCricket implements Game {

    @Override
    public void initialize() {
        System.out.println("GameCricket Game Initialized! Start playing.");
    }

    @Override
    public void startPlay() {
        System.out.println("GameCricket Game Started. Enjoy the game!");
    }

    @Override
    public void endPlay() {
        System.out.println("GameCricket Game Finished!");
    }
}