package com.lypgod.test.g02.structural.patterns.p08.criteria.pattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author richard
 */
public class CriteriaSingle implements Criteria {
   @Override
   public List<Person> filter(List<Person> persons) {
      return persons.stream().filter(e -> e.getMaritalStatus().equalsIgnoreCase(CRITERIA_MARITAL_SINGLE)).collect(Collectors.toList());
   }
}