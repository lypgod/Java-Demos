package com.lypgod.test.g04.j2ee.patterns.p29.data.access.object.pattern;

/**
 * @author richard
 */
public class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        // 输出所有的学生
        System.out.println("All students:");
        System.out.println(studentDao.getAllStudents());

        // 获取学生
        Student student = studentDao.getStudent(0);
        System.out.println("Student id 0:");
        System.out.println(student);

        // 更新学生
        student.setName("Michael");
        studentDao.updateStudent(student);
        System.out.println("Student id 0 updated:");
        System.out.println(student);

        // 删除学生
        studentDao.deleteStudent(student);
        System.out.println(studentDao.getAllStudents());
    }
}