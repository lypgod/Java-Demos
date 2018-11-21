package com.lypgod.await.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AwaitNotifyTest1 {
    private volatile List<String> strings = new ArrayList<>();

    private void add() {
        this.strings.add("aaaaaa");
    }

    private int getSize() {
        return this.strings.size();
    }

    public static void main(String[] args) {
        Object lock = new Object();
        AwaitNotifyTest1 awaitNotifyTest1 = new AwaitNotifyTest1();
        final boolean[] flag = {true};

        new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    awaitNotifyTest1.add();
                    System.out.println("element added, now size = " + awaitNotifyTest1.getSize() + " - " + Thread.currentThread().getName());
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, "Thread-1").start();

        new Thread(() -> {
                while (flag[0]) {
                    if (awaitNotifyTest1.getSize() == 5) {
                        flag[0] = false;
                        System.out.println("reach 5 by thread " + Thread.currentThread().getName());
                    }
                }
        }, "Thread-2").start();
    }
}
