package com.lypgod.test.g02.structural.patterns.p08.criteria.pattern;

/**
 * @author richard
 */
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;

    Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    String getGender() {
        return gender;
    }

    String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!gender.equals(person.gender)) return false;
        return maritalStatus.equals(person.maritalStatus);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + maritalStatus.hashCode();
        return result;
    }
}