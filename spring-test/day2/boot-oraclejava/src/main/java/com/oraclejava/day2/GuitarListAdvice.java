package com.oraclejava.day2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GuitarListAdvice {

    @Pointcut("execution(* com.oraclejava.day2.GuitarList.sing(..))")
    public void singExecution() {

    }

    @Before("singExecution()")
    public void singBeforeAdvice(JoinPoint jp) {
        System.out.println("기타 치기 전");
        System.out.println("타입: "+jp.getSignature().getDeclaringType());
        System.out.println("경로: "+jp.getSignature().getDeclaringTypeName());
        System.out.println("메소드 명: "+jp.getSignature().getName());
        System.out.println("메소드 명 풀 경로: "+jp.getSignature().toLongString());
    }

}
