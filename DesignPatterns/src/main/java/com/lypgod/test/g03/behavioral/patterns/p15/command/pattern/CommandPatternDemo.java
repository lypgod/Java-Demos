package com.lypgod.test.g03.behavioral.patterns.p15.command.pattern;

/**
 * @author richard
 */
public class CommandPatternDemo {
   public static void main(String[] args) {
      Stock abcStock = new Stock();
 
      Order buyStockOrder = new OrderBuyStock(abcStock);
      Order sellStockOrder = new OrderSellStock(abcStock);
 
      Broker broker = new Broker();
      broker.takeOrder(buyStockOrder);
      broker.takeOrder(sellStockOrder);
 
      broker.placeOrders();
   }
}