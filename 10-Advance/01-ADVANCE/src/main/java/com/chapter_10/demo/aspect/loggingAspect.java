package com.chapter_10.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {

    // advice: before running a certain method, do this
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Excuting @Before advice on addAccount() ");
    }
}