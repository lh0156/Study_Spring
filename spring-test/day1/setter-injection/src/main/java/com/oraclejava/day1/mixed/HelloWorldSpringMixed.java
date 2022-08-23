package com.oraclejava.day1.mixed;

import com.oraclejava.day1.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringMixed {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        System.out.println(ac.getBean("yun") + "대통령");

    }
}
