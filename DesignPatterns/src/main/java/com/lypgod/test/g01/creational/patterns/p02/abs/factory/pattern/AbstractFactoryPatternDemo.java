package com.lypgod.test.g01.creational.patterns.p02.abs.factory.pattern;

import java.util.Objects;

/**
 * @author richard
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为 ShapeCircle 的对象
        Shape shape1 = Objects.requireNonNull(shapeFactory).getShape("CIRCLE");
        //调用 ShapeCircle 的 draw 方法
        shape1.draw();
        //获取形状为 ShapeRectangle 的对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 ShapeRectangle 的 draw 方法
        shape2.draw();
        //获取形状为 ShapeSquare 的对象
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 ShapeSquare 的 draw 方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //获取颜色为 Red 的对象
        Color color1 = Objects.requireNonNull(colorFactory).getColor("RED");
        //调用 Red 的 fill 方法
        color1.fill();
        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("Green");
        //调用 Green 的 fill 方法
        color2.fill();
        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("BLUE");
        //调用 Blue 的 fill 方法
        color3.fill();
    }
}