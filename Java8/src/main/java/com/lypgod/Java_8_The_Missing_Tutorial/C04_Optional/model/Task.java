package com.lypgod.Java_8_The_Missing_Tutorial.C04_Optional.model;

import java.util.Optional;

public class Task {
    private final String title;
    private final Optional<User> assignedTo;
    private final String id;

    public Task(String id, String title) {
        this.id = id;
        this.title = title;
        assignedTo = Optional.empty();
    }

    public Task(String id, String title, User assignedTo) {
        this.id = id;
        this.title = title;
        this.assignedTo = Optional.ofNullable(assignedTo);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Optional<User> getAssignedTo() {
        return assignedTo;
    }
}