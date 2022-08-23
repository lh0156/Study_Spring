package com.oraclejava.day1.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ManWithAgeAnnotationTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext();

        ac.load("classpath:spring/app-context-annotation.xml");
        ac.refresh();

        ManWithAge manWithAge = (ManWithAge)ac.getBean("manWithAge");
        System.out.println(manWithAge);

        ac.close();
    }

}
