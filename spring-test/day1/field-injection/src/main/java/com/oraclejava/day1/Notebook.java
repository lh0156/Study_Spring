package com.oraclejava.day1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Notebook {

    @Value("thinkPad")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                '}';
    }
}
