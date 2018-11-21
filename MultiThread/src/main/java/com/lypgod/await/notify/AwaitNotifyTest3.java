package com.lypgod.await.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AwaitNotifyTest3 {
    private volatile List<String> strings = new ArrayList<>();

    private void add() {
        this.strings.add("aaaaaa");
    }

    private int getSize() {
        return this.strings.size();
    }

    public static void main(String[] args) {
        Object lock = new Object();
        AwaitNotifyTest3 awaitNotifyTest1 = new AwaitNotifyTest3();
        final CountDownLatch countDownLatch = new CountDownLatch(5);

        new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    awaitNotifyTest1.add();
                    System.out.println("element added, now size = " + awaitNotifyTest1.getSize() + " - " + Thread.currentThread().getName());
                    countDownLatch.countDown();
                    try {
                        TimeUnit.MILLISECONDS.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, "Thread-1").start();

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("reach 5 by thread " + Thread.currentThread().getName());
        }, "Thread-2").start();
    }
}
