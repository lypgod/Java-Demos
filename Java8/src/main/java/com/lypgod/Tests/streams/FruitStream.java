package com.lypgod.Tests.streams;

import lombok.extern.java.Log;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        FruitStream fruitStream = new FruitStream();

        fruitStream.getWantedFruit();
    }
}
