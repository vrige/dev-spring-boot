package com.SecondPartUdemy.springCoreDemo.config;

import com.SecondPartUdemy.springCoreDemo.common.Coach;
import com.SecondPartUdemy.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig{

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}