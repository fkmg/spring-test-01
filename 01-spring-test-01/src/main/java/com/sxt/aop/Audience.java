package com.sxt.aop;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* com.sxt.service.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void sleicenAllPhone(){
        System.out.println("Plilease Slience All Cell phone!!!");
    }

    @Before("performance()")
    public void takeSeates(){
        System.out.println("Plilease take seates !!!");
    }

    @AfterReturning("performance() && within(com.sxt.service.Performance)")
    public void applause(){
        System.out.println("Plilease appla use !!!");
    }

    @AfterThrowing("performance()")
    public void demondFound(){
        System.out.println("Demonding a refund!!!");
    }
}
