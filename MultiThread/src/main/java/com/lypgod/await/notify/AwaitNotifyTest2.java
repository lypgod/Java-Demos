package com.lypgod.await.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AwaitNotifyTest2 {
    private volatile List<String> strings = new ArrayList<>();

    private void add() {
        this.strings.add("aaaaaa");
    }

    private int getSize() {
        return this.strings.size();
    }

    public static void main(String[] args) {
        Object lock = new Object();
        AwaitNotifyTest2 awaitNotifyTest1 = new AwaitNotifyTest2();

        new Thread(() -> {
            synchronized (lock) {
                if (awaitNotifyTest1.getSize() == 5) {
                    System.out.println("reach 5 by thread " + Thread.currentThread().getName());
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-2").start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    awaitNotifyTest1.add();
                    System.out.println("element added, now size = " + awaitNotifyTest1.getSize() + " - " + Thread.currentThread().getName());
                    lock.notify();
                    try {
                        TimeUnit.MILLISECONDS.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-1").start();
    }
}
