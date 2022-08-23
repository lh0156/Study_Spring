package com.oraclejava.day1.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("manWithAge")
public class ManWithAge {
    private String age;

    public ManWithAge(String age) {
        this.age = age;
    }

    //OverLoad
    //직접 주입
    @Autowired
    public ManWithAge(@Value("19") int age) {
        System.out.println("여기를 타느냐?");
        this.age = "나이: " + age;
    }

    @Override
    public String toString() {
        return age;
    }
}
