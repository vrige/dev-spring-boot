package com.SecondPartUdemy.springCoreDemo.rest;

import com.SecondPartUdemy.springCoreDemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;


    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
        myCoach = theCoach;
    }

    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("In DomyStartUpStuff(): " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
