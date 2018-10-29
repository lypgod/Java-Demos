package com.lypgod;

import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class VolatileTest {
    private boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    private void printThreadName() {
        while (isRunning) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest test = new VolatileTest();
        new Thread(test::printThreadName).start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(() -> {
            System.out.println("设置isRunning为false。");
            test.setRunning(false);
        }).start();
    }
}
