package com.lypgod.singleton;

/**
 * @author richard
 */
public class SingletonTest {
    private static SingletonTest instance = new SingletonTest();
    private static String VARIABLE = "Hello World!";

    private SingletonTest() {
        System.out.println("Singleton Created!");
    }

    public static SingletonTest getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(SingletonTest.VARIABLE);
        }
    }
}
