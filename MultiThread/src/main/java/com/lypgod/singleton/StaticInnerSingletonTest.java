package com.lypgod.singleton;

/**
 * @author richard
 */
public class StaticInnerSingletonTest {
    private static class SingletonHolder {
        static final StaticInnerSingletonTest INSTANCE = new StaticInnerSingletonTest();
    }

    private StaticInnerSingletonTest() {}

    public static StaticInnerSingletonTest getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
