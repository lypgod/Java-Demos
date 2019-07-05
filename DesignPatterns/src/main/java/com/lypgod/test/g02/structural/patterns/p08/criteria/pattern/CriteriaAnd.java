package com.lypgod.test.g02.structural.patterns.p08.criteria.pattern;

import java.util.List;

/**
 * @author richard
 */
public class CriteriaAnd implements Criteria {
    private Criteria criteria1;
    private Criteria criteria2;

    CriteriaAnd(Criteria criteria1, Criteria criteria2) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
    }

    @Override
    public List<Person> filter(List<Person> persons) {
        return criteria2.filter(criteria1.filter(persons));
    }
}