package com.lypgod.test.g04.j2ee.patterns.p29.data.access.object.pattern;

import java.util.List;

/**
 * @author richard
 */
public interface StudentDao {
    /**
     * getAllStudents
     * @return List<Student>
     */
    List<Student> getAllStudents();

    /**
     * getStudent
     * @param id int
     * @return Student
     */
    Student getStudent(int id);

    /**
     * updateStudent
     * @param student Student
     */
    void updateStudent(Student student);

    /**
     * deleteStudent
     * @param student Student
     */
    void deleteStudent(Student student);
}