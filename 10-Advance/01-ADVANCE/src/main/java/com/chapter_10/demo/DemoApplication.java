package com.chapter_10.demo;

import com.chapter_10.demo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO){
		return runner ->{
			demoTheBeforeAdvice(theAccountDAO);
			demoTheBeforeAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {

		theAccountDAO.addAccount();
	}
}
