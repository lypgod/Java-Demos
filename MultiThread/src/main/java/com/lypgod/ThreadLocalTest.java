package com.lypgod;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class ThreadLocalTest {
    private static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    private void setThreadLocal(List<String> values) {
        threadLocal.set(values);
    }

    private void getThreadLocal() {
        System.out.println(Thread.currentThread().getName());
        threadLocal.get().forEach(System.out::println);
    }

    public static void main(String[] args) {
        final ThreadLocalTest test = new ThreadLocalTest();
        new Thread(() -> {
            test.setThreadLocal(Arrays.asList("张三", "李四", "王五"));
            test.getThreadLocal();
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.setThreadLocal(Arrays.asList("Chinese", "English"));
            test.getThreadLocal();
        }).start();
    }
}
