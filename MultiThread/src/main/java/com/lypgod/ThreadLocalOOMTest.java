package com.lypgod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author richard
 */
public class ThreadLocalOOMTest {
    private static final int THREAD_POOL_SIZE = 500;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 10000;

    private static class User {
        private String userName;
        private String password;
        private String sex;
        private int age;

        User(String userName, String password, String sex, int age) {
            this.userName = userName;
            this.password = password;
            this.sex = sex;
            this.age = age;
        }
    }

    private static ThreadLocal<List<User>> threadLocal = new ThreadLocal<>();

    private List<User> addBigList() {
        List<User> params = new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
        for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
            params.add(new User("testUser", "password", "male", i));
        }
        return params;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executorService.execute(() -> {
                threadLocal.set(new ThreadLocalOOMTest().addBigList());
                System.out.println(Thread.currentThread().getName());
                 threadLocal.remove(); // 不取消注释的话可能出现OOM
            });

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

         executorService.shutdown();
    }
}
