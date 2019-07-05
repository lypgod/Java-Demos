package com.lypgod.test.g03.behavioral.patterns.p25.visitor.pattern;

/**
 * @author richard
 */
public class ComputerPartMonitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}