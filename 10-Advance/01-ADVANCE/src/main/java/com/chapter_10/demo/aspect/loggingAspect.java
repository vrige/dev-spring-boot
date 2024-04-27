package com.chapter_10.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {

    // Notice that if you specify the full path of a method or class, you can restrict
    // the adcive to that specific class.
    // You can use the wildcard * to extend the advice to more methods.
    // you can also specify a class and use ".." in case of multiple arguments in the method
    
    // advice: before running a certain method, do this
    @Before("execution(public void add*())")
    public void beforeAddAdvice(){
        System.out.println("\n=====>>> Excuting @Before advice on addSomething() ");
    }

    @Before("execution(public void addAccount(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Excuting @Before advice on addAccount() ");
    }

    @Before("execution(void addAccount())")
    public void beforeAddAccountVoidAdvice(){
        System.out.println("\n=====>>> Excuting @Before advice on addAccount() with return type void ");
    }

    @Before("execution(* addAccount())")
    public void beforeAddAccountAnyReturnTypeAdvice(){
        System.out.println("\n=====>>> Excuting @Before advice on addAccount() with any return type");
    }

    @Before("execution(* add*(com.chapter_10.demo.Account))")
    public void beforeAddAccountAdviceWildCards(){
        System.out.println("\n=====>>> Excuting @Before advice on addAccount() with wildcards");
    }
}