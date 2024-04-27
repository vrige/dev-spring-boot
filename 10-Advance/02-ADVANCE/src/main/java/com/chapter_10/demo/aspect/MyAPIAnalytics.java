package com.chapter_10.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.cache.annotation.CachePut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAPIAnalytics {

    @Before("com.chapter_10.demo.aspect.MyExpressions.getter()")
    public void performGetter(){
        System.out.println("\n=====>>> A getter (Analytics)!!");
    }
}