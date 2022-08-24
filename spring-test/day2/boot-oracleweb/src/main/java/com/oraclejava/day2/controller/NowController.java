package com.oraclejava.day2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
@RestController
public class NowController {

    @RequestMapping("/now")
    public String now() {
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);

        int hour24 = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        String temp = getTemp(hour24);

        String now = temp + " " + year + "-" + month + "-" + date + " " + hour24 + ":" + minute + ":" + second;
        return now;
    }

    public String getTemp (int time) {
        if(time>12) {
            return "오후";
        } else {
            return "오전";
        }
    }

}
