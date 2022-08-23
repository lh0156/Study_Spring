package com.oraclejava.day1.xml;

// 나이를 가진 남자
public class ManWithAge {
    private String age;

    public ManWithAge(String age) {
        this.age = age;
    }

    //OverLoad
    public ManWithAge(int age) {
        System.out.println("여기를 타느냐?");
        this.age = "나이: " + age;
    }

    @Override
    public String toString() {
        return age;
    }
}
