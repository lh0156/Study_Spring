package com.oraclejava.day2;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext();
        ac.load("classpath:spring/app-context.xml");
        ac.refresh();

        Calendarer localBean = ac.getBean("localTime", Calendarer.class);
        localBean.printTime();

        Calendarer LABean = ac.getBean("LATime", Calendarer.class);
        LABean.printTime();

        Calendarer LondonBean = ac.getBean("LondonTime", Calendarer.class);
        LondonBean.printTime();

        ac.close();
    }
}
