package com.lypgod;

import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class SyncTest {
    static class Sup {
        int i = 5;
        public synchronized void opSup() {
            i--;
            System.out.println("Super print i = " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Sup {
        synchronized void opSub() {
            while (i > 0) {
                i--;
                System.out.println("Sub print i = " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        new Thread(sub::opSub).start();
    }
}
