package com.oraclejava.day1.xml;

import com.oraclejava.day1.annotation.ManWithAge;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ManWithAgeXmlTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext();

        ac.load("spring/app-context-xml.xml");
        ac.refresh();

        ManWithAge bean = (ManWithAge) ac.getBean("man2");
    }
}
