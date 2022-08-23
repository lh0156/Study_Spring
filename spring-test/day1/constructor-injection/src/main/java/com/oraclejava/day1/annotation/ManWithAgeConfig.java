package com.oraclejava.day1.annotation;

import com.oraclejava.day1.annotation.ManWithAge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManWithAgeConfig {

    @Bean
    public ManWithAge manWithAge() {
        ManWithAge manWithAge = new ManWithAge(90);
        return manWithAge;
    }
}
