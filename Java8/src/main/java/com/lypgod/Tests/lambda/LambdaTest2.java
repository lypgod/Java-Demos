package com.lypgod.Tests.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author lypgo
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // Old way
        for (Integer n : list) {
            System.out.println(n);
        }

        // Lambda way
        list.forEach(System.out::println);
    }

    interface Inter {
        void method1();
        static void method2() {
            System.out.println("method2");
        }
    }
}
