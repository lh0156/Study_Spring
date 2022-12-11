package com.seop.jwt.reflection;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Dog {

    private static final String CATEGORY = "동물";

    private String name;
    private int age;

    private Dog() {
        this.name = "누렁이";
        this.age = 0;
    }

    private Dog(final String name) {
        this.name = name;
        age = 0;
    }

    private Dog(final String name, final int age) {
        this.name = name;
        this.age = age;
    }
}