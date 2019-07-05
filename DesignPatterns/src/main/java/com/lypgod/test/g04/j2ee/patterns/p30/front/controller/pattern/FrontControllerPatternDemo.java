package com.lypgod.test.g04.j2ee.patterns.p30.front.controller.pattern;

/**
 * @author richard
 */
public class FrontControllerPatternDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}