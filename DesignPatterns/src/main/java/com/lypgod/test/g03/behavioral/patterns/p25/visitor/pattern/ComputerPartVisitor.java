package com.lypgod.test.g03.behavioral.patterns.p25.visitor.pattern;

/**
 * @author richard
 */
public interface ComputerPartVisitor {
    /**
     * visit
     *
     * @param computer ComputerPartComputer
     */
    void visit(ComputerPartComputer computer);

    /**
     * visit
     *
     * @param mouse ComputerPartMouse
     */
    void visit(ComputerPartMouse mouse);

    /**
     * visit
     *
     * @param keyboard ComputerPartKeyboard
     */
    void visit(ComputerPartKeyboard keyboard);

    /**
     * visit
     *
     * @param monitor ComputerPartMonitor
     */
    void visit(ComputerPartMonitor monitor);
}