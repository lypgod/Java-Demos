package com.lypgod;

/**
 * @author richard
 */
public class ThreadTest extends Thread {
    private int count = 5;

    @Override
    public synchronized void run() {
        this.count--;
        System.out.println(currentThread().getName() + " count:" + this.count);
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread thread1 = new Thread(threadTest, "thread1");
        Thread thread2 = new Thread(threadTest, "thread2");
        Thread thread3 = new Thread(threadTest, "thread3");
        Thread thread4 = new Thread(threadTest, "thread4");
        Thread thread5 = new Thread(threadTest, "thread5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
