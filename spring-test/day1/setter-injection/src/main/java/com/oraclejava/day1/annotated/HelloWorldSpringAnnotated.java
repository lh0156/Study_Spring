package com.oraclejava.day1.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        Person person = ac.getBean("person", Person.class);

        System.out.println(person + " 대통령");

    }
}
