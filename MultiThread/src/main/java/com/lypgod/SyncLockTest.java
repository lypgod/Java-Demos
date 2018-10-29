package com.lypgod;

import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class SyncLockTest {
    private String lock = "lock";

    private void method() {
        synchronized (lock) {
            System.out.println("当前线程： " + Thread.currentThread().getName() + "开始");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程： " + Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        final SyncLockTest test = new SyncLockTest();
        new Thread(test::method, "t1").start();
        new Thread(test::method, "t2").start();
    }
}
