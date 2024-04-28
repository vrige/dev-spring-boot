package com.chapter_10.demo.aspect;

import com.chapter_10.demo.Account;
import com.chapter_10.demo.dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class loggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.chapter_10.demo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowing(JoinPoint theJoinPoint, Throwable theExc){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Excuting @AfterThrowing advice on method: " + method);

        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.chapter_10.demo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAcconutsAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>> Excuting @AfterReturning advice on method: " + method);

        System.out.println("results: " + result);
    }

    @Before("com.chapter_10.demo.aspect.MyExpressions.forDaoPackage()")
    public void beforeAddAccountAdviceWildCards(){
        System.out.println("\n=====>>> Excuting @Before advice on addAccount() with wildcards");
    }

    @Before("com.chapter_10.demo.aspect.MyExpressions.forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n=====>>> Performing API analytics");
    }

    @Before("com.chapter_10.demo.aspect.MyExpressions.getter()")
    public void performGetter(){
        System.out.println("\n=====>>> A getter!!");
    }

    @Before("com.chapter_10.demo.aspect.MyExpressions.setter()")
    public void performSetter(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> A setter!!");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("MEthod: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());

            }
        }
    }


}