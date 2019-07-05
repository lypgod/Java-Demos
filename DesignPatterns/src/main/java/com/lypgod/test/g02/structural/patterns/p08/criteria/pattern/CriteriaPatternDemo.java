package com.lypgod.test.g02.structural.patterns.p08.criteria.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
public class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria maleFilter = new CriteriaMale();
        Criteria femaleFilter = new CriteriaFemale();
        Criteria singleFilter = new CriteriaSingle();
        Criteria singleMaleFilter = new CriteriaAnd(singleFilter, maleFilter);
        Criteria singleOrFemaleFilter = new CriteriaOr(singleFilter, femaleFilter);

        System.out.println("Males: ");
        printPersons(maleFilter.filter(persons));

        System.out.println("\nFemales: ");
        printPersons(femaleFilter.filter(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMaleFilter.filter(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemaleFilter.filter(persons));
    }

    private static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus()
                    + " ]");
        }
    }
}