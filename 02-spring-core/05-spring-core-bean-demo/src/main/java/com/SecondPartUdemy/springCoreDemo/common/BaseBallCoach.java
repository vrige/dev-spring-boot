package com.SecondPartUdemy.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class BaseBallCoach implements Coach{

    public BaseBallCoach(){
        System.out.println("In construcotr: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice 45 minutes of baseball. No complains";
    }

}
