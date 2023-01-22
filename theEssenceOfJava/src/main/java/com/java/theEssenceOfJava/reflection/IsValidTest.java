package com.java.theEssenceOfJava.reflection;

import java.lang.reflect.Field;

public class IsValidTest {

    public static void main(String[] args) {

        String value = "age";

        if(IsValid.isValid(value, new Member())) {
            System.out.println(value + "라는 값이 포함되어 있습니다");
        } else {
            System.out.println("값이 없습니다");
        }

    }

    static class Member {
        String name;
        int age;
        String address;
    }
}
