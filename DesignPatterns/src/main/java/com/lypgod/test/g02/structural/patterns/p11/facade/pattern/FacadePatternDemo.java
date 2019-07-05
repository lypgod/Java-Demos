package com.lypgod.test.g02.structural.patterns.p11.facade.pattern;

/**
 * @author richard
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeFacade shapeFacade = new ShapeFacade();

        shapeFacade.drawCircle();
        shapeFacade.drawRectangle();
        shapeFacade.drawSquare();
    }
}