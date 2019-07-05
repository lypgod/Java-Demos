package com.lypgod.singleton;

/**
 * @author richard
 */

public enum EnumSingleton {
    // 实例
    INSTANCE;

    int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}