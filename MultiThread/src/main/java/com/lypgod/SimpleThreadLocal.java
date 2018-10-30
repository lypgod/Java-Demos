package com.lypgod;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class SimpleThreadLocal<T> {
    /**
     * Key为线程对象，Value为保存的值对象
     */
    private Map<Thread, T> valueMap = Collections.synchronizedMap(new HashMap<>());

    private void set(T value) {
        valueMap.put(Thread.currentThread(), value);
    }

    private T get() {
        Thread thread = Thread.currentThread();
        T t = valueMap.get(thread);
        if (t == null && !valueMap.containsKey(thread)) {
            t = initValue();
            valueMap.put(thread, t);
        }
        return t;
    }

    private T initValue() {
        return null;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public static void main(String[] args) {
        SimpleThreadLocal<List<String>> threadLocal = new SimpleThreadLocal<>();
        new Thread(() -> {
            threadLocal.set(Arrays.asList("张三", "李四", "王五"));
            threadLocal.get().forEach(e -> System.out.println(Thread.currentThread().getName() + " element: " + e));
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                threadLocal.set(Arrays.asList("Chinese", "English"));
                threadLocal.get().forEach(e -> System.out.println(Thread.currentThread().getName() + " element: " + e));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
