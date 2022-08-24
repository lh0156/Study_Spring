package com.oraclejava.day2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "안녕하세요 엄윤섭입니다...";
    }

}
