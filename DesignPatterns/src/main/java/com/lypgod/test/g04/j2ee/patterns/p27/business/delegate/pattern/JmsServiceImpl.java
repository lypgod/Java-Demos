package com.lypgod.test.g04.j2ee.patterns.p27.business.delegate.pattern;

/**
 * @author richard
 */
public class JmsServiceImpl implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}