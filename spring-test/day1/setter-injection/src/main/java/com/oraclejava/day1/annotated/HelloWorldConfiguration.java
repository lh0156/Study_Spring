package com.oraclejava.day1.annotated;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan(basePackages = "com.oraclejava.day1.annotated")
@Configuration
public class HelloWorldConfiguration {
}
