package com.lypgod.test.g02.structural.patterns.p08.criteria.pattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author richard
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> filter(List<Person> persons) {
        return persons.stream().filter(e -> e.getGender().equalsIgnoreCase(CRITERIA_GENDER_FEMALE)).collect(Collectors.toList());
    }
}