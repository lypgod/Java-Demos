package com.lypgod.test.g03.behavioral.patterns.p25.visitor.pattern;

/**
 * @author richard
 */
public class ComputerPartComputer implements ComputerPart {
    private ComputerPart[] parts;

    ComputerPartComputer() {
        this.parts = new ComputerPart[]{new ComputerPartMouse(), new ComputerPartKeyboard(), new ComputerPartMonitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart part : this.parts) {
            part.accept(computerPartVisitor);
        }

        computerPartVisitor.visit(this);
    }
}