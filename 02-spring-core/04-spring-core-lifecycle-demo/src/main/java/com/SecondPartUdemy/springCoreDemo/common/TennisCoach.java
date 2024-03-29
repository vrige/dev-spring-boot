package com.SecondPartUdemy.springCoreDemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In construcotr: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice 30 minutes of Tennis";
    }

}
