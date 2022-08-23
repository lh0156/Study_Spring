package com.oraclejava.day1.mixed;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:spring/app-context.xml")
@Configuration
public class HelloWorldConfiguration {

}
