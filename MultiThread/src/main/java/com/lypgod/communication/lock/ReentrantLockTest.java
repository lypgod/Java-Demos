package com.lypgod.communication.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author richard
 */
public class ReentrantLockTest {
    private static void runMethod(Lock lock, int sleepTime) {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
            System.out.println("Thread name: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(() -> runMethod(lock, 0), "thread1").start();
        new Thread(() -> runMethod(lock, 5), "thread2").start();
        new Thread(() -> runMethod(lock, 1), "thread3").start();
        new Thread(() -> runMethod(lock, 5), "thread4").start();
        new Thread(() -> runMethod(lock, 1), "thread5").start();
    }
}
