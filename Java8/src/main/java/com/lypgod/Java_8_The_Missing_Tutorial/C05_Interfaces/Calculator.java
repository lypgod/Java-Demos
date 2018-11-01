package com.lypgod.Java_8_The_Missing_Tutorial.C05_Interfaces;

/**
 * @author richard
 */
public interface Calculator {

    static Calculator getInstance() {
        return new BasicCalculator();
    }

    int add(int first, int second);

    int subtract(int first, int second);

    int divide(int number, int divisor);

    int multiply(int first, int second);

    default int remainder(int number, int divisor) {
        return subtract(number, multiply(divisor, divide(number, divisor)));
    }
}