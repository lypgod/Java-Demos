package com.lypgod.test.g02.structural.patterns.p07.bridge.pattern;

/**
 * @author richard
 */
public abstract class AbstractShape {
    DrawCircle drawCircle;

    AbstractShape(DrawCircle drawCircle) {
        this.drawCircle = drawCircle;
    }

    /**
     * draw
     */
    public abstract void draw();
}