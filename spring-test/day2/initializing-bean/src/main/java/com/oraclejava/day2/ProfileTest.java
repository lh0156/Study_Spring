package com.oraclejava.day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileTest {
    public static void main(String[] args) {
        //스프링으로
        //xml 전용
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext();

        ac.load("spring/app-context.xml");
        ac.refresh();

        Profile bean = ac.getBean(Profile.class);
        System.out.println(bean);

        ac.close();


    }
}
