package com.lypgod.communication.wait_notify;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author richard
 */
public class QueueTest {
    /**
     * 需要一个承装元素的集合
     */
    private final LinkedList<Object> list = new LinkedList<>();
    /**
     * 需要一个计数器
     */
    private final AtomicInteger count = new AtomicInteger(0);
    /**
     * 需要指定上限和下限
     */
    private final int maxSize = 5;
    private final int minSize = 0;
    /**
     * 初始化锁对象
     */
    private final Object lock = new Object();

    private int size() {
        return this.list.size();
    }

    private void put(Object obj) {
        synchronized (lock) {
            // 达到上限无法添加，进入等待
            while (count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj);
            count.getAndIncrement();
            System.out.println("元素 " + obj + " 被添加。");
            lock.notify();
        }
    }

    private Object get() {
        Object temp;
        synchronized (lock) {
            // 达到下限，无法获取，进入等待
            while (count.get() == minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count.getAndDecrement();
            temp = list.removeFirst();
            System.out.println("元素 " + temp + " 被取出。");
            lock.notify();
        }
        return temp;
    }

    public static void main(String[] args) throws InterruptedException {
        final QueueTest test = new QueueTest();
        test.put("a");
        test.put("b");
        test.put("c");
        test.put("d");
        test.put("e");
        System.out.println("初始化完毕，当前元素个数：" + test.size());

        new Thread(() -> {
            test.put("h");
            test.put("i");
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                test.get();
                TimeUnit.SECONDS.sleep(2);
                test.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
