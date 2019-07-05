package com.lypgod.test.g04.j2ee.patterns.p31.intercepting.filter.pattern;

/**
 * @author richard
 */
public class FilterManager {
    private FilterChain filterChain;

    FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void addFilter(Filter filter) {
        this.filterChain.addFilter(filter);
    }

    void filterRequest(String request) {
        this.filterChain.execute(request);
    }
}