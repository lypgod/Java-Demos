package com.lypgod.test.g04.j2ee.patterns.p32.service.locator.pattern;

/**
 * @author richard
 */
class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    static Service getService(String jndiName) {

        Service service = cache.getService(jndiName);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}