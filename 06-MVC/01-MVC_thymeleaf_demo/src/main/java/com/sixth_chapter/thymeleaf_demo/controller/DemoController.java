package com.sixth_chapter.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model theModel){

        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        return "helloworld";
    }
}