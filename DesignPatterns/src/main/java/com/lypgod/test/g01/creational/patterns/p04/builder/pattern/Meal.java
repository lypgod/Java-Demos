package com.lypgod.test.g01.creational.patterns.p04.builder.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
class Meal {
    private List<Item> items = new ArrayList<>();

    void addItem(Item item) {
        this.items.add(item);
    }

    float getCost() {
        return (float) this.items.stream().mapToDouble(Item::price).sum();
    }

    void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}