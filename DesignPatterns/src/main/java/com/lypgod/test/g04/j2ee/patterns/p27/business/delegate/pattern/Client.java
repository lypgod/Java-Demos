package com.lypgod.test.g04.j2ee.patterns.p27.business.delegate.pattern;

/**
 * @author richard
 */
class Client {
    private BusinessDelegate businessService;

    Client(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    void doTask() {
        businessService.doTask();
    }
}