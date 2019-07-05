package com.lypgod.test.g04.j2ee.patterns.p27.business.delegate.pattern;

/**
 * @author richard
 */
public interface BusinessService {
   String SERVICE_EJB = "EJB";
   String SERVICE_JMS = "JMS";
   /**
    * doProcessing
    */
   void doProcessing();
}