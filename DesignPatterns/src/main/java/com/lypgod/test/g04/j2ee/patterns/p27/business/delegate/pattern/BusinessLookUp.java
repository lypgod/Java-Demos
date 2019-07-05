package com.lypgod.test.g04.j2ee.patterns.p27.business.delegate.pattern;

import static com.lypgod.test.g04.j2ee.patterns.p27.business.delegate.pattern.BusinessService.SERVICE_EJB;
import static com.lypgod.test.g04.j2ee.patterns.p27.business.delegate.pattern.BusinessService.SERVICE_JMS;

/**
 * @author richard
 */
class BusinessLookUp {
    BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase(SERVICE_EJB)) {
            return new EjbServiceImpl();
        }
        if (serviceType.equalsIgnoreCase(SERVICE_JMS)) {
            return new JmsServiceImpl();
        }
        throw new RuntimeException("Service type not found.");
    }
}