package com.lypgod.test.g01.creational.patterns.p03.singleton.pattern;

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

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.setValue(5);
        System.out.println(EnumSingleton.INSTANCE.getValue());
    }
}