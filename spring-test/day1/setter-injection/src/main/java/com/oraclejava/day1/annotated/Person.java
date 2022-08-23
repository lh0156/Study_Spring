package com.oraclejava.day1.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("person")
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    @Autowired
    public void setName(@Value("이재명") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
