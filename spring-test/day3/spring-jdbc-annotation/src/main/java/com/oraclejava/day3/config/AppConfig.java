package com.oraclejava.day3.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db/jdbc.properties")
@ComponentScan(basePackages = "com.oraclejava.day3")
public class AppConfig {
    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    
}
