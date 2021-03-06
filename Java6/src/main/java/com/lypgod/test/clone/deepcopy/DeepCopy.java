package com.lypgod.test.clone.deepcopy;

/**
 * @author richard
 */
public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        long t1 = System.currentTimeMillis();
        Professor professor = new Professor("wangwu", 50);
        Student s1 = new Student("zhangsan", 18, professor);
        Student s2 = (Student) s1.clone();
        s2.professor.name = "lisi";
        s2.professor.age = 30;
        System.out.println("学生s1的姓名：" + s1.name);
        System.out.println("学生s1教授的姓名：" + s1.professor.name);
        System.out.println("学生s1教授的年纪：" + s1.professor.age);
        long t2 = System.currentTimeMillis();
        System.out.println("耗时：" + (t2 - t1));
    }
}