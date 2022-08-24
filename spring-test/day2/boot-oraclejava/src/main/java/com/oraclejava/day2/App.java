package com.oraclejava.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Random;

@SpringBootApplication
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("스프링 부트를 시작합니다. 출발!");

        ConfigurableApplicationContext ac = SpringApplication.run(App.class, args);

//        HelloWorld bean = ac.getBean("helloWorld", HelloWorld.class);
//        bean.sayHi();

        GuitarList guitarList = ac.getBean("KimTaeWon", GuitarList.class);
        guitarList.sing();

        ac.close();

    }
}
