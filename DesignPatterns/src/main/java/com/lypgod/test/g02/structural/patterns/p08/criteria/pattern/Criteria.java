package com.lypgod.test.g02.structural.patterns.p08.criteria.pattern;

import java.util.List;

/**
 * @author richard
 */
public interface Criteria {
    String CRITERIA_GENDER_MALE = "MALE";
    String CRITERIA_GENDER_FEMALE = "FEMALE";
    String CRITERIA_MARITAL_SINGLE = "SINGLE";
    String CRITERIA_MARITAL_MARRIED = "MARRIED";

    /**
     * meetCriteria
     * @param persons List
     * @return List
     */
    List<Person> filter(List<Person> persons);
}