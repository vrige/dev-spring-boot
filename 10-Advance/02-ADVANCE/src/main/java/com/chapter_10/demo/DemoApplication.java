package com.chapter_10.demo;

import com.chapter_10.demo.dao.AccountDAO;
import com.chapter_10.demo.dao.MemberDAOimpl;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberDAOimpl memberDAOimpl){
		return runner ->{
			demoTheBeforeAdvice(theAccountDAO, memberDAOimpl);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MemberDAOimpl memberDAOimpl) {

		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");

		theAccountDAO.addAccount(myAccount);

		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

	}
}
