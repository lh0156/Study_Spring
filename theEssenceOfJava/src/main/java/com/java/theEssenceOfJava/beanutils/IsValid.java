package com.java.theEssenceOfJava.beanutils;

import java.lang.reflect.Field;

public class IsValid {

    public static <T> boolean isValid(String value, T t) {

        boolean isValidFlag = false;

        for(Field field : t.getClass().getDeclaredFields()) {
            if (field.equals(value)) {
                isValidFlag = true;
                break;
            }
        }

        return isValidFlag;

    }
}
