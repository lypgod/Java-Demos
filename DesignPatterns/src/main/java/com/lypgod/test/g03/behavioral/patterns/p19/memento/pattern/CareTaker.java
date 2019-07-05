package com.lypgod.test.g03.behavioral.patterns.p19.memento.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento state) {
        this.mementoList.add(state);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}