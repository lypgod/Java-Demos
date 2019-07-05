package com.lypgod.test.g04.j2ee.patterns.p31.intercepting.filter.pattern;

/**
 * @author richard
 */
public class InterceptingFilterDemo {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.addFilter(new FilterAuthentication());
        filterManager.addFilter(new FilterDebug());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}