package com.lypgod.Tests.collector;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class CollectorTest {
    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    private static void testAveragingInt() {
        System.out.print("testAveragingInt: ");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testAveragingDouble() {
        System.out.print("testAveragingDouble: ");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testAveragingLong() {
        System.out.print("testAveragingLong: ");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testModifyingResult() {
        List<Dish> collect = menu.stream().filter(d -> d.getType().equals(Dish.Type.OTHER)).collect(Collectors.toList());
        collect.add(new Dish("", false, 100, Dish.Type.OTHER));
        System.out.println(collect);

        List<Dish> collect1 = menu.stream().filter(d -> d.getType().equals(Dish.Type.OTHER)).collect(
                Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        collect1.add(new Dish("", false, 100, Dish.Type.OTHER));
        System.out.println(collect1);
    }

    private static void testCollectingAndThen() {
        System.out.print("testCollectingAndThen: ");
        Optional.ofNullable(menu.stream().collect(Collectors.
                collectingAndThen(Collectors.averagingInt(Dish::getCalories), a -> "CAlumniate " + a)))
                .ifPresent(System.out::println);
    }

    private static void testCounting() {
        System.out.print("counting: ");
        Optional.of(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    private static void testGroupingBy() {
        System.out.print("testGroupingByFunction: ");
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType))).
                ifPresent(System.out::println);
    }

    private static void testGroupingByAndCollect() {
        System.out.print("testGroupingByAndCollect");
        Optional.ofNullable(
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories))
                )
        ).ifPresent(System.out::println);
    }

    private static void testSummarizingInt() {
        System.out.print("testSummarizingInt: ");
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByConcurrent() {
        System.out.println("testGroupingByConcurrentWithFunction");
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testJoining() {
        System.out.print("testJoining: ");
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining())).ifPresent(System.out::println);
    }


    private static void testJoiningWithDelimiter() {
        System.out.print("testJoiningWithDelimiter: ");
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(","))).ifPresent(System.out::println);
    }

    private static void testJoiningWithDelimiterAndPrefixAndSuffix() {
        System.out.print("testJoiningWithDelimiterAndPrefixAndSuffix: ");
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(",", "Names[", "]")))
                .ifPresent(System.out::println);
    }

    private static void testMapping() {
        System.out.print("testMapping: ");
        Optional.ofNullable(menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")))).ifPresent(System.out::println);
    }

    private static void testMaxBy() {
        System.out.print("testMaxBy: ");
        Optional.ofNullable(menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)))).ifPresent(System.out::println);

    }

    private static void testMinBy() {
        System.out.print("testMinBy: ");
        menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        CollectorTest.testAveragingInt();
        CollectorTest.testAveragingDouble();
        CollectorTest.testAveragingLong();
        CollectorTest.testModifyingResult();
        CollectorTest.testCollectingAndThen();
        CollectorTest.testCounting();
        CollectorTest.testGroupingBy();
        CollectorTest.testGroupingByAndCollect();
        CollectorTest.testSummarizingInt();
        CollectorTest.testGroupingByConcurrent();
        CollectorTest.testJoining();
        CollectorTest.testJoiningWithDelimiter();
        CollectorTest.testJoiningWithDelimiterAndPrefixAndSuffix();
        CollectorTest.testMapping();
        CollectorTest.testMaxBy();
        CollectorTest.testMinBy();

    }
}
