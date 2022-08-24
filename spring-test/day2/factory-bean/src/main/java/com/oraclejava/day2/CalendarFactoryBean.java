package com.oraclejava.day2;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarFactoryBean implements InitializingBean, FactoryBean<Calendar> {
    String city = null;
    Calendar cal = null;


    @Override
    public Calendar getObject() throws Exception {
        return cal;
    }

    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(city == null) {
            cal = Calendar.getInstance();
        } else {
            cal = Calendar.getInstance(TimeZone.getTimeZone(city));
        }

    }

    public void setCity(String city) {
        this.city = city;
    }
}
