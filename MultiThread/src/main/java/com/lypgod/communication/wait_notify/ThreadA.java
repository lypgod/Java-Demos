package com.lypgod.communication.wait_notify;

/**
 * @author richard
 */
public class ThreadA extends Thread {
    private Object lock;

    ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (MyList.size() != 5) {
                System.out.println("线程A开始等待 - " + System.currentTimeMillis());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程A等待结束 - " + System.currentTimeMillis());
            }
        }
    }
}
