package com.lypgod.test.g03.behavioral.patterns.p25.visitor.pattern;

/**
 * @author richard
 */
public class ComputerPartVisitorImpl implements ComputerPartVisitor {
    @Override
    public void visit(ComputerPartComputer computerPartComputer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(ComputerPartMouse computerPartMouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(ComputerPartKeyboard computerPartKeyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(ComputerPartMonitor computerPartMonitor) {
        System.out.println("Displaying Monitor.");
    }
}