package com.lypgod.Tests.lambda;

import java.util.Arrays;

/**
 * @author lypgo
 */
public class LambdaTest {
    @FunctionalInterface
    interface Func {
        String go(String s);
    }

    @FunctionalInterface
    interface FuncArr {
        int[] go(int n);
    }

    public static void main(String[] args) {
        Func f = String::new;
        FuncArr funcArr = int[]::new;
        System.out.println(f.go("HaHa"));
        System.out.println(Arrays.toString(funcArr.go(3)));
    }
}
