package com.lypgod;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lypgo
 */
public class CountDownLatchTest {
    private static final int THREAD_COUNT_NUM = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT_NUM; i++) {
            int index = i + 1;
            new Thread(() -> {
                System.out.println("第" + index + "颗龙珠已收集！");
                // 模拟收集龙珠所用的时间
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();
            }).start();
        }

        System.out.println("等待集齐7颗龙珠");
        countDownLatch.await();
        System.out.println("集齐7颗龙珠！开始召唤神龙！！");
    }
}
