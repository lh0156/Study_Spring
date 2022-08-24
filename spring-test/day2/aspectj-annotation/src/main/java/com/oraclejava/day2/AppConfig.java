package com.oraclejava.day2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.oraclejava.day2"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//true  = true로 하면 class로 다이렉트로 타겟을 할 수 있다.
//false = interface를 하나 만들어야 한다.
public class AppConfig {



}
