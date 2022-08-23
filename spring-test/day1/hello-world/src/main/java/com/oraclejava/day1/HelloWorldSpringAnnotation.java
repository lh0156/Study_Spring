package com.oraclejava.day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //Person person = ac.getBean("person", Person.class);
        //System.out.println(person);

        Volunteer volunteer = ac.getBean("volunteer", Volunteer.class);
        System.out.println(volunteer);


    }
}
