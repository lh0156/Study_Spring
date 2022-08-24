package com.oraclejava.day2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KeyAdvice {

    @AfterReturning(value = "execution(* getKey())", returning = "returnValue")
    public void afterReturning(JoinPoint jp, Object returnValue) {
        //jp.getSignature().getModifiers()
        long key = (Long) returnValue;

        if (key == KeyGenerator.WEAK_KEY) {
            throw new SecurityException("그런 키는 안됩니다...");
        }
    }

}
