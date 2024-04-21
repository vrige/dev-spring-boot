package com.crud.demo;

import com.crud.demo.dao.AppDAO;
import com.crud.demo.entity.Instructor;
import com.crud.demo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO){

		/*
		Instructor tempInstructor = new Instructor("Chad","Darby", "darby@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://something", "Love is important");
		*/
		Instructor tempInstructor = new Instructor("madhu","len", "madhu@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://somethingElse", "Playing guitar");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
	}
}
