package com.FirstApp.course.firstAppSpringBoot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/")
    public String sayhello(){
        return "Hello World!!!!";
    }

    @GetMapping("/workout")
    public String saySomething(){
        return "ciao bello! Il mio nome è " + coachName;
    }

}