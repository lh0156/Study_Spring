package com.oraclejava.day2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext();
        ac.load("classpath:spring/app-context.xml");
        ac.refresh();

        MessageDigester bean = ac.getBean(MessageDigester.class);
        bean.digest("ILoveYou");

        ac.close();
    }
}
