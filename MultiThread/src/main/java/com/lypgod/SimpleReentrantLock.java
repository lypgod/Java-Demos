package com.lypgod;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SimpleReentrantLock implements Lock {
    private final Sync sync = new Sync();

    /**
     * AQS的子类Sync
     */
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            // 当前状态是0为获取锁
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 释放锁，将状态设置为0
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            // 是否处于占用状态
            return getState() == 1;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        this.sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return this.sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        this.sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return this.sync.newCondition();
    }

    public static void main(String[] args) {
        SimpleReentrantLock lock = new SimpleReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("进入等待...");
                condition.await();
                System.out.println("接收到通知，继续进行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "conditionAwaitThread").start();

        new Thread(() -> {
            try {
                System.out.println("模拟3秒后发送通知...");
                TimeUnit.SECONDS.sleep(3);
                lock.lock();
                System.out.println("发送通知！");
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "conditionSIgnalThread").start();
    }
}
