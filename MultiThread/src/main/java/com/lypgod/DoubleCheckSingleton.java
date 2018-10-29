package com.lypgod;

import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            try {
                //模拟初始化对象时间...
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //类上加锁，表示当前对象不可以在其他线程的时候创建
            synchronized (DoubleCheckSingleton.class) {
                //如果不加这一层判断的话，每一个线程会得到一个实例，而不是所有线程得到一个实例。
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
