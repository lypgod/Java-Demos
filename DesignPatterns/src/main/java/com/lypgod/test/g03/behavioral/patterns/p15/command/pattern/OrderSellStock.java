package com.lypgod.test.g03.behavioral.patterns.p15.command.pattern;

/**
 * @author richard
 */
public class OrderSellStock implements Order {
    private Stock abcStock;

    OrderSellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}