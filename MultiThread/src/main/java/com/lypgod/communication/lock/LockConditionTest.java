package com.lypgod.communication.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author richard
 */
public class LockConditionTest {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    private void await(Condition condition) {
        try {
            lock.lock();
            System.out.println("Thread name: " + Thread.currentThread().getName() + " starting await... ");
            condition.await();
            System.out.println("Thread name: " + Thread.currentThread().getName() + " await finished. ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal(Condition condition) {
        lock.lock();
        System.out.println("Thread name: " + Thread.currentThread().getName() + " sending signal... ");
        condition.signal();
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        final LockConditionTest test = new LockConditionTest();
        new Thread(() -> test.await(test.conditionA), "thread_1_condition_A").start();
        new Thread(() -> test.await(test.conditionB), "thread_2_condition_B").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> test.signal(test.conditionA), "thread_3_condition_A").start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(() -> test.signal(test.conditionB), "thread_4_condition_B").start();
    }
}
