package com.java.theEssenceOfJava.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestClass {

    @Autowired(required = false)
    TestService testService;

    @PostConstruct
    public void temp() {
        System.out.println("testService: " + testService);
        testService.print();
    }
}
