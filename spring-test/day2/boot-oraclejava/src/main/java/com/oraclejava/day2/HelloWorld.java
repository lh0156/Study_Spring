package com.oraclejava.day2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public void sayHi() {
        logger.info("안녕하세요 임형구입니다...");
    }
}
