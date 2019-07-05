package com.lypgod.test.g04.j2ee.patterns.p29.data.access.object.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
public class StudentDaoImpl implements StudentDao {
    private List<Student> students;

    StudentDaoImpl() {
        this.students = new ArrayList<>();
        this.students.add(new Student(0, "Robert"));
        this.students.add(new Student(1, "John"));
    }

    @Override
    public List<Student> getAllStudents() {
        return this.students;
    }

    @Override
    public Student getStudent(int id) {
        return this.students.get(id);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getId()).setName(student.getName());
        System.out.println("Student with id: " + student.getId() + ", updated in the database");
    }

    @Override
    public void deleteStudent(Student student) {
        this.students.remove(student.getId());
        System.out.println("Student with id: " + student.getId() + ", deleted from database");
    }
}