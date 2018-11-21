package com.lypgod.test.inner_class;

public class Main {
    public void go(final int n) {
        final int m = 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(m);
                System.out.println(n);
            }
        }).start();
    }
}
