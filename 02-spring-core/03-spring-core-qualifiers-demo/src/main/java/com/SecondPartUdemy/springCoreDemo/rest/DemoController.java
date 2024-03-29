package com.SecondPartUdemy.springCoreDemo.rest;

import com.SecondPartUdemy.springCoreDemo.common.Coach;
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
    private Coach mySecondCoach;

    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach, @Qualifier("tennisCoach") Coach secondCoach){
        mySecondCoach = secondCoach;
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("check")
    public String check(){return "the two coaches are equal: " + (mySecondCoach == myCoach);}
}
