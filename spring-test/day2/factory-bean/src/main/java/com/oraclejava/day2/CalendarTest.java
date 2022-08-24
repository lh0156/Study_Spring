package com.oraclejava.day2;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(
                //TimeZone.getTimeZone("America/Los_Angeles")
                ); //항상 Local의 현재 시간

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);

        System.out.println(hour + "시 "+ min + "분");
    }
}
