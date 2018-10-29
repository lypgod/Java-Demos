package com.lypgod.streams;

import lombok.extern.java.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author richard
 */
@Log
public class FruitStream {

    private void getWantedFruit() {
        Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
        //找到所有包含字母a的水果，改大写，排序。
        fruitStream.filter(e -> e.contains("a")).sorted().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("WantedFruit -----------------------------");
    }

    private void testParallelStreamOrder() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        integers.parallelStream().forEach(System.out::println);
        System.out.println("ParallelStreamOrder -----------------------------");
    }

    private void testStreamCreation() throws IOException {
//        Stream<String> streamOfArray = Stream.of("a", "b", "c");
//        streamOfArray.forEach(System.out::println);
//        System.out.println("streamOfArray -----------------------------");
//
//        String[] arr = new String[]{"a", "b", "c"};
//        Stream<String> streamOfArrayFull = Arrays.stream(arr);
//        streamOfArrayFull.forEach(System.out::println);
//        System.out.println("streamOfArrayFull -----------------------------");
//        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
//        streamOfArrayPart.forEach(System.out::println);
//        System.out.println("streamOfArrayPart -----------------------------");
//
//        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
//        streamBuilder.forEach(System.out::println);
//        System.out.println("streamBuilder -----------------------------");

//        Stream<Double> streamGenerated = Stream.generate(Math::random).limit(10);
//        streamGenerated.forEach(System.out::println);
//        System.out.println("streamGenerated -----------------------------");

//        Stream.generate(Math::random).mapToInt(e -> (int) (e * 10)).limit(20).sorted().distinct().forEach(System.out::println);

//        final int[] prev = {0};
//        IntStream.iterate(1, operand -> {
//            int temp = operand + prev[0];
//            prev[0] = operand;
//            return temp;
//        }).limit(10).forEach(System.out::println);

//        new Random().ints(222, 0, 11).distinct().sorted().forEach(System.out::println);

//        IntStream streamOfChars = "abc".chars();
//        streamOfChars.forEach(System.out::println);

        Path path = Paths.get("/home/richard/Demo/JavaPractice/pom.xml");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset =Files.lines(path, Charset.forName("UTF-8"));
        streamWithCharset.forEach(System.out::println);
    }

    private void testStreamReference() {
        Stream<String> streamOfArray = Stream.of("a", "b", "c").filter(e -> e.contains("b"));
        Optional<String> optionalString = streamOfArray.findAny();
        System.out.println(optionalString.orElse(""));
    }

    private void testStreamPipline() {
        // Stream Pipline = 源数据 -> 直接操作（多个） -> 一个终结方法。
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();
        System.out.println(size);
    }

    private void  testStreamTrigger() {
        long count = Stream.of("abc1", "abc2", "abc3").filter(element -> {
            log.info("filter() " + element + " was called");
            return element.contains("2");
        }).map(element -> {
            log.info("map() " + element + " was called");
            return element.toUpperCase();
        }).count();
        System.out.println(count);
    }

    private void  testStreamReduce() {
        OptionalInt reduced  = IntStream.rangeClosed(1, 4).reduce((a, b) -> a > b ? a : b);
        System.out.println(reduced.orElse(0));
        int reducedTwoParams = IntStream.range(1, 4).reduce(11, (a, b) -> a + b);
        System.out.println(reducedTwoParams);
    }

    private void  testStreamaAcumulatorCombiner() {
        int reducedParams = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> {
            log.info("combiner was called");
            return a + b;
        });
        System.out.println(reducedParams);

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    log.info("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParallel);
    }

    public static void main(String[] args) throws IOException {
        FruitStream fruitStream = new FruitStream();

//        fruitStream.getWantedFruit();
//        fruitStream.testParallelStreamOrder();
//        fruitStream.testStreamCreation();
//        fruitStream.testStreamReference();
//        fruitStream.testStreamPipline();
//        fruitStream.testStreamTrigger();
//        fruitStream.testStreamReduce();

        fruitStream.testStreamaAcumulatorCombiner();
    }
}
