package com.lypgod.Java_8_The_Missing_Tutorial.C04_Optional.model;

import java.util.Optional;

public class User {

    private final String username;
    private final Optional<String> address;

    public User(String username) {
        this.username = username;
        this.address = Optional.empty();
    }

    public User(String username, String address) {
        this.username = username;
        this.address = Optional.ofNullable(address);
    }

    public String getUsername() {
        return username;
    }

    public Optional<String> getAddress() {
        return address;
    }
}