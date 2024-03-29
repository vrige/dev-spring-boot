package com.FirstApp.course.firstAppSpringBoot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayhello(){
        return "Hello World";
    }


}