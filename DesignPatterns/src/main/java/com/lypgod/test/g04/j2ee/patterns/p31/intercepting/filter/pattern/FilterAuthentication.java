package com.lypgod.test.g04.j2ee.patterns.p31.intercepting.filter.pattern;

/**
 * @author richard
 */
public class FilterAuthentication implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}