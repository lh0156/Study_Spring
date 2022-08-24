package com.oraclejava.day2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class KeyGenDemo {
    public static void main(String[] args) {
        GenericApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        KeyGenerator bean = ac.getBean(KeyGenerator.class);


        long key = bean.getKey();
        System.out.println(key);

        ac.close();

    }
}
