package com.lypgod;

import java.util.concurrent.*;

/**
 * @author lypgo
 */
public class ThreadPoolTest {
    private static void divTask(int a, int b) {
        double result = a / b;
        System.out.println(result);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++) {
            int index = i;
            Future<?> future = executorService.submit(() -> divTask(100, index));
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
