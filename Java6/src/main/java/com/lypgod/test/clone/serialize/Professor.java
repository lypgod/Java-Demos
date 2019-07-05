package com.lypgod.test.clone.serialize;

import java.io.Serializable;

class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
