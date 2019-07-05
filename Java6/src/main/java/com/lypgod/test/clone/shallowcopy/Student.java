package com.lypgod.test.clone.shallowcopy;

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
        return super.clone();
    }
}
