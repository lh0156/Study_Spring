package com.oraclejava.day2;

import java.util.Calendar;

public class Calendarer {

    private Calendar cal;

    public void setCalendar(Calendar cal) {
        this.cal = cal;
    }

    public void printTime() {
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);

        System.out.println(hour + "시 "+ min + "분");
    }
}
