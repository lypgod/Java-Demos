package com.lypgod.test.g04.j2ee.patterns.p26.mvc.pattern;

/**
 * @author richard
 */
public class Student {
    private String rollNo;
    private String name;

    String getRollNo() {
        return rollNo;
    }

    void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}