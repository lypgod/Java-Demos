package com.lypgod.test.g04.j2ee.patterns.p31.intercepting.filter.pattern;

/**
 * @author richard
 */
public interface Filter {
    /**
     * execute
     *
     * @param request String
     */
    void execute(String request);
}