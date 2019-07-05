package com.lypgod.test.g04.j2ee.patterns.p31.intercepting.filter.pattern;

/**
 * @author richard
 */
class Client {
    private FilterManager filterManager;

    void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    void sendRequest(String request) {
        this.filterManager.filterRequest(request);
    }
}