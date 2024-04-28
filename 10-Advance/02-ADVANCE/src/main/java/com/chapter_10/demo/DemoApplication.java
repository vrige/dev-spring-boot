package com.chapter_10.demo;

import com.chapter_10.demo.dao.AccountDAO;
import com.chapter_10.demo.dao.MemberDAOimpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberDAOimpl memberDAOimpl){
		return runner ->{
			//demoTheBeforeAdvice(theAccountDAO, memberDAOimpl);
			// demoTheAfterReturningAdvice(theAccountDAO);
			demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;

		try{
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("\n\nMainProgram: demoTheAfterReturningAdvice. Exception: " + exc);
		}
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\nMainProgram: demoTheAfterReturningAdvice");

		System.out.println(theAccounts);

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
