package com.oraclejava.day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/app-context.xml");

        Volunteer volunteer = ac.getBean("volunteer", Volunteer.class);

        System.out.println(volunteer);
    }
}
