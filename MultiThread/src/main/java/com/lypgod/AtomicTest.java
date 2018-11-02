package com.lypgod;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest extends Thread {
    private static AtomicInteger value = new AtomicInteger();
    private static final int THREAD_COUNT_NUM = 100;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    System.out.println("Thread - " + index + " set value: " + value.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();
        System.out.println("Finished, final value: " + value.get());
    }
}
