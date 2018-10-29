package com.lypgod;

/**
 * @author richard
 */
public class SyncExceptionTest {
    private int i = 0;

    private synchronized void operation() {
        while (true) {
            i++;
            System.out.println(Thread.currentThread().getName() + ", i = " + i);
            if (i == 10) {
                Integer.parseInt("a");
            }
        }
    }

    public static void main(String[] args) {
        final SyncExceptionTest test = new SyncExceptionTest();
        new Thread(test::operation).start();
    }
}
