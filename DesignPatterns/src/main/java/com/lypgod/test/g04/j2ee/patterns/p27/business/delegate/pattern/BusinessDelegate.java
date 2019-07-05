package com.lypgod.test.g04.j2ee.patterns.p27.business.delegate.pattern;

/**
 * @author richard
 */
class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;

    void setServiceType(String serviceType) {
        this.businessService = lookupService.getBusinessService(serviceType);
    }

    void doTask() {
        this.businessService.doProcessing();
    }
}