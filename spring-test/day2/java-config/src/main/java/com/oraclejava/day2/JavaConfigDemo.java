package com.oraclejava.day2;

import com.oraclejava.day1.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JavaConfigDemo {

    //정적 중첩 클래스
    @Configuration
    static class AppConfig {

        @Bean
        public Person person() {
            Person person = new Person();
            person.setName("현주엽");
            person.setAge(47);
            return person;
        }
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ac.getBean("person", Person.class);
        System.out.println("이름: " + person.getName());
        System.out.println("나이: " + person.getAge());
    }

}
