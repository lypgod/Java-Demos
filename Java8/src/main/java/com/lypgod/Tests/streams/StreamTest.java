package com.lypgod.Tests.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Log
public class StreamTest {

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
        Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
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

    private void testStreamTrigger() {
        long count = Stream.of("abc1", "abc2", "abc3").filter(element -> {
            log.info("filter() " + element + " was called");
            return element.contains("2");
        }).map(element -> {
            log.info("map() " + element + " was called");
            return element.toUpperCase();
        }).count();
        System.out.println(count);
    }

    private void testStreamReduce() {
        OptionalInt reduced = IntStream.rangeClosed(1, 4).reduce((a, b) -> a > b ? a : b);
        System.out.println(reduced.orElse(0));
        int reducedTwoParams = IntStream.range(1, 4).reduce(11, (a, b) -> a + b);
        System.out.println(reducedTwoParams);
    }

    private void testStreamaAcumulatorCombiner() {
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

    private void testStreamCollect() {
        List<Product> productList = Arrays.asList(
                new Product(23.3, "potatoes", 3),
                new Product(14.5, "orange", 5),
                new Product(13, "lemon", 2),
                new Product(23.32, "bread", 14),
                new Product(13.145, "sugar",22)
        );

        System.out.printf("Fruits: %s%n", productList.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]")));

        System.out.printf("SubTotal Price: %s%n", productList.stream().map((e) -> String.valueOf(e.getPrice() * e.getQuantity())).collect(Collectors.joining(", ", "[", "]")));

        System.out.printf("Average Price: %s%n", productList.stream().collect(Collectors.averagingDouble(Product::getPrice)));

        System.out.printf("Total Price: %s%n", (Double) productList.stream().mapToDouble(e -> e.getQuantity() * e.getPrice()).sum());

        System.out.printf("Price Summary: %s%n", productList.stream().collect(Collectors.summarizingDouble(Product::getPrice)));

        System.out.printf("Total Price Summary: %s%n", productList.stream().collect(Collectors.summarizingDouble(e -> e.getQuantity() * e.getPrice())));
    }

    public static void main(String[] args) throws IOException {
        StreamTest test = new StreamTest();

//        test.getWantedFruit();
//        test.testParallelStreamOrder();
//        test.testStreamCreation();
//        test.testStreamReference();
//        test.testStreamPipline();
//        test.testStreamTrigger();
//        test.testStreamReduce();
//        test.testStreamaAcumulatorCombiner();

        test.testStreamCollect();
    }

    @Getter
    @AllArgsConstructor
    private class Product {
        private double price;
        private String name;
        private int quantity;
    }
}
