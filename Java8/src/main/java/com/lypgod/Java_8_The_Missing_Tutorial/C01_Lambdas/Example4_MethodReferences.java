package com.lypgod.Java_8_The_Missing_Tutorial.C01_Lambdas;

import java.util.*;
import java.util.function.Function;

public class Example4_MethodReferences {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");

        List<Integer> namesLength = transform(names, String::length);
        System.out.println(namesLength);

        List<String> upperCaseNames = transform(names, String::toUpperCase);
        System.out.println(upperCaseNames);

        List<Integer> numbers = transform(Arrays.asList("1", "2", "3"), Integer::parseInt);
        System.out.println(numbers);

        Collections.sort(names, Comparator.comparingInt(String::length).reversed());
        System.out.println(names);
    }

    private static <T, R> List<R> transform(List<T> list, Function<T, R> fx) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(fx.apply(element));
        }
        return result;
    }
}