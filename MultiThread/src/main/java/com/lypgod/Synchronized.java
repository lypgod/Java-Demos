package com.lypgod;

public class Synchronized {
    private static synchronized void method() {
    }

    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        method();
    }
}