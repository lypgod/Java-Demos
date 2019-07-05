package com.lypgod.test.g04.j2ee.patterns.p33.transfer.object.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
public class StudentBO {
    /**
     * 列表是当作一个数据库
     */
    private List<StudentVO> students;

    StudentBO() {
        this.students = new ArrayList<>();
        this.students.add(new StudentVO("Robert", 0));
        this.students.add(new StudentVO("John", 1));
    }

    public void deleteStudent(StudentVO student) {
        students.remove(student.getRollNo().intValue());
        System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
    }

    List<StudentVO> getAllStudents() {
        return students;
    }

    StudentVO getStudent(int rollNo) {
        return students.get(rollNo);
    }

    void updateStudent(StudentVO student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }
}