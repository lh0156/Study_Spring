package com.oraclejava.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("volunteer")
public class Volunteer {
    @Autowired
    private Person person;

    @Autowired
    private Notebook notebook;

    public void showInfo() {
        System.out.println("사람 정보: " + person.getName());
        System.out.println("노트북 정보: " + notebook.getName());
    }
}
