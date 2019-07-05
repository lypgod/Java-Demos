package com.lypgod.test.g02.structural.patterns.p07.bridge.pattern;

/**
 * @author richard
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        AbstractShape redCircle = new Circle(100, 100, 10, new DrawRedCircle());
        AbstractShape greenCircle = new Circle(100, 100, 10, new DrawGreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}