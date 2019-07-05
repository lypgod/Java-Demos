package com.lypgod.test.g03.behavioral.patterns.p25.visitor.pattern;

/**
 * @author richard
 */
public interface ComputerPart {
    /**
     * accept
     *
     * @param computerPartVisitor ComputerPartVisitor
     */
    void accept(ComputerPartVisitor computerPartVisitor);
}