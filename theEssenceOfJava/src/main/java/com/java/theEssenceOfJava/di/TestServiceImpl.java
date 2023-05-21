package com.java.theEssenceOfJava.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public void print() {
        System.out.println("print");
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
