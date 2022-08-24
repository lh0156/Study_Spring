package com.oraclejava.day2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.oraclejava.day2.Cat.speak())")
    public void catSpeak() {

    }

    @Pointcut("execution(* com.oraclejava.day2.Cat.setBreed(String))")
    public void catBreed() {

    }

    @Pointcut("execution(* com.oraclejava.day2.Cat.getBreed())")
    public void catGetBreed() {

    }

    @Before("catSpeak()")
    public void hello() {
        System.out.println("안녕~ 방가방가~~~");
    }

    @AfterReturning(value="catGetBreed()", returning = "breed")
    public void afterReturning(JoinPoint jp, String breed) {
        System.out.println("returning method:" +
                jp.getSignature());

        System.out.println("리턴된 값: " + breed);
    }

    @AfterThrowing(value = "catBreed()", throwing = "ex")
    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("*** 공통 예외 처리 ***");
        System.out.println("잡힘" + ex.getClass().getName());

    }

    @Around("catSpeak()")
    public Object aroundHello(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before hello");
        Object retVal = pjp.proceed();
        System.out.println("after hello");
        return retVal;
    }



}
