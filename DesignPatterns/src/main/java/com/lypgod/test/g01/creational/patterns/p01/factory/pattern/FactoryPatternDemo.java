package com.lypgod.test.g01.creational.patterns.p01.factory.pattern;

/**
 * @author richard
 */
public class FactoryPatternDemo {
   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      Shape shapeCircle = shapeFactory.getShape("CIRCLE");
      shapeCircle.draw();

      Shape shapeRectangle = shapeFactory.getShape("RECTANGLE");
      shapeRectangle.draw();

      Shape shapeSquare = shapeFactory.getShape("SQUARE");
      shapeSquare.draw();
   }
}