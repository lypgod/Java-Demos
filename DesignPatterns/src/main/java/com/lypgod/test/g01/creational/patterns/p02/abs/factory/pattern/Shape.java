package com.lypgod.test.g01.creational.patterns.p02.abs.factory.pattern;

/**
 * @author richard
 */
public interface Shape {
   String SHAPE_CIRCLE = "CIRCLE";
   String SHAPE_RECTANGLE = "RECTANGLE";
   String SHAPE_SQUARE = "SQUARE";

   /**
    * draw
    */
   void draw();
}