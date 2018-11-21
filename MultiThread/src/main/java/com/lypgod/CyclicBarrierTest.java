package com.lypgod;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author lypgo
 */
public class CyclicBarrierTest {
    private final static int THREAD_COUNT_NUM = 7;

    /**
     * 收集龙珠，召唤神龙
     */
    private static void summonDragon() {
        // 设置第二个屏障点，等待7位法师收集完7颗龙珠，召唤神龙
        CyclicBarrier summonDragonBarrier = new CyclicBarrier(THREAD_COUNT_NUM, () -> System.out.println("已经集齐7颗龙珠，开始召唤神龙！"));

        // 收集龙珠
        for (int i = 0; i < THREAD_COUNT_NUM; i++) {
            int index = i + 1;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    System.out.println("第" + index + "颗龙珠已收集！");
                    summonDragonBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /**
     * 召集7位法师
     */
    public static void main(String[] args) {
        CyclicBarrier gatherWizardsBarrier = new CyclicBarrier(THREAD_COUNT_NUM, () -> {
            System.out.println("7个法师召集完毕，出发寻找龙珠！");
            summonDragon();
        });

        // 召集法师
        for (int i = 0; i < THREAD_COUNT_NUM; i++) {
            int index = i + 1;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    System.out.println("第" + index + "个法师已到！");
                    gatherWizardsBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
