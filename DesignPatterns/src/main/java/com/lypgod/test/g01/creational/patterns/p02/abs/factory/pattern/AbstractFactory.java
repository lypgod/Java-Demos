package com.lypgod.test.g01.creational.patterns.p02.abs.factory.pattern;

/**
 * @author richard
 */
public abstract class AbstractFactory {
   /**
    * getColor
    * @param color String
    * @return Color
    */
   public abstract Color getColor(String color);

   /**
    * getShape
    * @param shape String
    * @return AbstractShape
    */
   public abstract Shape getShape(String shape) ;
}