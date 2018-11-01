package com.lypgod.Java_8_The_Missing_Tutorial.C05_Interfaces;

public class App1 implements A {
    @Override
    public void doSth() {
        System.out.println("inside App1");
    }

    public static void main(String[] args) {
        new App1().doSth();
    }
}

interface A {
    default void doSth() {
        System.out.println("inside A");
    }
}