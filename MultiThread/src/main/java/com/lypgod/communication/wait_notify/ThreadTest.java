package com.lypgod.communication.wait_notify;

import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new ThreadA(lock).start();
        TimeUnit.MILLISECONDS.sleep(50);
        new ThreadB(lock).start();
    }
}
