package com.lypgod;

/**
 * @author richard
 */
public class ObjectTest {
    private void method() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final ObjectTest test = new ObjectTest();
        new Thread(test::method, "t1").start();
        new Thread(test::method, "t2").start();
    }
}
