package com.lypgod.singleton;

/**
 * @author richard
 */
public class LazySingletonTest {
    private static LazySingletonTest instance;
    private static String VARIABLE = "Hello World!";

    private LazySingletonTest() {
        System.out.println("LazySingleton Created!");
    }

    public synchronized LazySingletonTest getInstance() {
        if (instance == null) {
            instance = new LazySingletonTest();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(LazySingletonTest.VARIABLE);
        }
    }
}
