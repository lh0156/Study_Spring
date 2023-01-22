package com.java.theEssenceOfJava.reflection;

import java.lang.reflect.Field;

public class IsValid {

    public static <T> boolean isValid(String value, T t) {

        boolean isValidFlag = false;

        for(Field field : t.getClass().getDeclaredFields()) {
            if (field.getName().equals(value)) {
                isValidFlag = true;
                break;
            }
        }

        return isValidFlag;

    }
}
