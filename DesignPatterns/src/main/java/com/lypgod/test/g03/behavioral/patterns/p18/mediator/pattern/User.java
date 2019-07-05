package com.lypgod.test.g03.behavioral.patterns.p18.mediator.pattern;

/**
 * @author richard
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    User(String name) {
        this.name = name;
    }

    void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}