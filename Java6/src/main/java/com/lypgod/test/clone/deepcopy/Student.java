package com.lypgod.test.clone.deepcopy;

class Student implements Cloneable {
    String name;
    int age;
    Professor professor;

    Student(String name, int age, Professor professor) {
        this.name = name;
        this.age = age;
        this.professor = professor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.professor = (Professor) this.professor.clone();
        return student;
    }
}