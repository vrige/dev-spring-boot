package com.SecondPartUdemy.springCoreDemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("in construction: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Swim 1000 meters as a warm up";
    }
}
