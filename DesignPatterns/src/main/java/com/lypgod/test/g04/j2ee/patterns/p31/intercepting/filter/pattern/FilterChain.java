package com.lypgod.test.g04.j2ee.patterns.p31.intercepting.filter.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private Target target;

    void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    void setTarget(Target target) {
        this.target = target;
    }

    public void execute(String request) {
        this.filters.forEach(e -> e.execute(request));
        target.execute(request);
    }
}