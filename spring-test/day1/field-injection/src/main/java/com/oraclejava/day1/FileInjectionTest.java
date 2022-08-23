package com.oraclejava.day1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FileInjectionTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext();
        ac.load("classpath:spring/app-context.xml");
        ac.refresh();

        Volunteer volumnteer = ac.getBean(Volunteer.class);

        volumnteer.showInfo();

    }
}
