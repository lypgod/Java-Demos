package com.lypgod.Java_8_The_Missing_Tutorial.C04_Optional;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String id) {
        super("No task found for id: " + id);
    }
}