package com.java.theEssenceOfJava.di;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl2 implements TestService {

    @Override
    public void print() {
        System.out.println("haha44444");
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
