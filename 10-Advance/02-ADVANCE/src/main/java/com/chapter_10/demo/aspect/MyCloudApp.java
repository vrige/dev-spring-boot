package com.chapter_10.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudApp {

    @Before("com.chapter_10.demo.aspect.MyExpressions.getter()")
    public void performGetter(){
        System.out.println("\n=====>>> A getter(cloud)!!");
    }

}