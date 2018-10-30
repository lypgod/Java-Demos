package com.lypgod.singleton;

/**
 * @author richard
 */
public class DCLSingletonTest {
    private volatile static DCLSingletonTest singleton;
    private DCLSingletonTest (){

    }
    public static DCLSingletonTest getInstance() {
        if (singleton == null) {
            synchronized (DCLSingletonTest.class) {
                if (singleton == null) {
                    singleton = new DCLSingletonTest();
                }
            }
        }
        return singleton;
    }
}
