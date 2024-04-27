package com.chapter_10.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyExpressions {

    @Pointcut("execution(* com.chapter_10.demo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.chapter_10.demo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("execution(* add*())")
    public void forDaoPackage(){}
}