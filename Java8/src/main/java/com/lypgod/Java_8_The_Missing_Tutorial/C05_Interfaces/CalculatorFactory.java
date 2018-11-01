package com.lypgod.Java_8_The_Missing_Tutorial.C05_Interfaces;

public abstract class CalculatorFactory {
    public static Calculator getInstance() {
        return new BasicCalculator();
    }
}