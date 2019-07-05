package com.lypgod.singleton;

/**
 * @author richard
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }
}
