package com.lypgod.communication.wait_notify;

import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class ThreadB extends Thread {
    private Object lock;

    ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                MyList.add();
                if (MyList.size() == 5) {
                    lock.notify();
                    System.out.println("线程B已发出通知");
                }
                System.out.println("已添加" + MyList.size() + "个元素");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
