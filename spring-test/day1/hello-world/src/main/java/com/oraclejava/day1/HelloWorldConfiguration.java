package com.oraclejava.day1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("현주엽");
        person.setAge(47);
        return person;
    }

    @Bean
    public Volunteer volunteer() {
        Volunteer volunteer = new Volunteer();
        volunteer.setPerson(person());
        volunteer.setNotebook("씽크 패드");
        return volunteer;
    }
}
