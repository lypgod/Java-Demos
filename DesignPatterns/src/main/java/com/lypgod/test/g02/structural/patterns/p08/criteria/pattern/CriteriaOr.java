package com.lypgod.test.g02.structural.patterns.p08.criteria.pattern;

import java.util.*;

/**
 * @author richard
 */
public class CriteriaOr implements Criteria {
    private Criteria criteria1;
    private Criteria criteria2;

    CriteriaOr(Criteria criteria1, Criteria criteria2) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
    }

    @Override
    public List<Person> filter(List<Person> persons) {
        Set<Person> filteredPersonsSet = new HashSet<>();
        filteredPersonsSet.addAll(this.criteria1.filter(persons));
        filteredPersonsSet.addAll(this.criteria2.filter(persons));
        return new ArrayList<>(filteredPersonsSet);
    }
}