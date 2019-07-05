package com.lypgod.test.clone.shallowcopy;

/**
 * @author richard
 */
public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Professor professor = new Professor("wangwu", 50);
        Student s1 = new Student("zhangsan", 18, professor);
        Student s2 = (Student) s1.clone();
        s2.professor.name = "lisi";
        s2.professor.age = 30;
        s2.name = "z";
        s2.age = 45;
        System.out.println("学生s1的姓名：" + s1.name);
        System.out.println("学生s1教授的姓名：" + s1.professor.name);
        System.out.println("学生s1教授的年纪：" + s1.professor.age);
    }
}