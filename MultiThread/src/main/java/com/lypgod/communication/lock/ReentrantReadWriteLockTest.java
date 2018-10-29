package com.lypgod.communication.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author richard
 */
public class ReentrantReadWriteLockTest {
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " got read  lock @" + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    private void write() {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " got write lock @" + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
        new Thread(test::read).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(test::write).start();
    }
}
