package com.lypgod.test.g03.behavioral.patterns.p18.mediator.pattern;

import java.util.Date;

/**
 * @author richard
 */
class ChatRoom {
    static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}