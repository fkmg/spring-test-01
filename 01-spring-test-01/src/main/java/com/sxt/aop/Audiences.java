package com.sxt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audiences {

    @Pointcut("execution(* com.sxt.service.Performance.perform(..))")
    public void performance(){}

    @AfterThrowing("performance()")
    public void demondFound(){
        System.out.println("Demonding a refund!!!");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint pjp){

        try {
            System.out.println("Plilease Slience All Cell phone!!!");
            System.out.println("Plilease take seates !!!");
            pjp.proceed();
            System.out.println("Plilease appla use !!!");
        } catch (Throwable throwable) {
            System.out.println("Demonding a refund!!!");
            //throwable.printStackTrace();
        }
    }
}
