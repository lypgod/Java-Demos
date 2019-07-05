package com.lypgod.test.g04.j2ee.patterns.p26.mvc.pattern;

/**
 * @author richard
 */
class StudentView {
    void printStudentDetails(Student student) {
        System.out.println("Student: ");
        System.out.println("Name: " + student.getName());
        System.out.println("Roll No: " + student.getRollNo());
    }
}