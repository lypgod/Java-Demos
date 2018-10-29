package com.lypgod;

/**
 * @author richard
 */
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName()), "t1").start();
    }
}
