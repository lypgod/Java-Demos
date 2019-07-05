package com.lypgod.test.g03.behavioral.patterns.p15.command.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
class Broker {
    private List<Order> orderList = new ArrayList<>();

    void takeOrder(Order order) {
        orderList.add(order);
    }

    void placeOrders() {
        orderList.forEach(Order::execute);
        orderList.clear();
    }
}