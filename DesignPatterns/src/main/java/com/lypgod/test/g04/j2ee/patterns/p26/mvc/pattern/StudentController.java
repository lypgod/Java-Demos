package com.lypgod.test.g04.j2ee.patterns.p26.mvc.pattern;

/**
 * @author richard
 */
public class StudentController {
    private Student model;
    private StudentView view;

    StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    void setStudentName(String name) {
        this.model.setName(name);
    }

    public String getStudentName() {
        return this.model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        this.model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return this.model.getRollNo();
    }

    void updateView() {
        view.printStudentDetails(this.model);
    }
}