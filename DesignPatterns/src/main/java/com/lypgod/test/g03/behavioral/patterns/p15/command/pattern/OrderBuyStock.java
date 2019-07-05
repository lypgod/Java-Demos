package com.lypgod.test.g03.behavioral.patterns.p15.command.pattern;

/**
 * @author richard
 */
public class OrderBuyStock implements Order {
    private Stock abcStock;

    OrderBuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}