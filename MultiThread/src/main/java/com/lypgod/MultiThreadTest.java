package com.lypgod;

import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class MultiThreadTest {
    private static int num = 200;

    private synchronized void printNum(String threadName, String tag) {
        num -= ("a".equals(tag) ? 100 : 200);
        System.out.println(threadName + " tag " + tag + "set num over, num = " + num);
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadTest threadTest1 = new MultiThreadTest();
        MultiThreadTest threadTest2 = new MultiThreadTest();
        new Thread(() -> threadTest1.printNum("thread1", "a")).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("等待2秒，确保thread1执行完毕。");
        new Thread(() -> threadTest2.printNum("thread2", "b")).start();
    }
}
