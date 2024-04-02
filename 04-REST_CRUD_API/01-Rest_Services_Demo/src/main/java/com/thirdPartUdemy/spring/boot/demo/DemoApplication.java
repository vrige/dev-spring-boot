package com.thirdPartUdemy.spring.boot.demo;

import com.thirdPartUdemy.spring.boot.demo.dao.StudentDAO;
import com.thirdPartUdemy.spring.boot.demo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createMultipleStudents(studentDAO);
		};

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent1 = new Student("Paul","Doe","paul@gmail.com");
		Student tempStudent2 = new Student("Mary","Doe","mary@gmail.com");
		Student tempStudent3 = new Student("Dean","dong","dean@gmail.com");


		System.out.println("Saving the student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved students. Generated Id: " + tempStudent1.getId() + ", " + tempStudent2.getId() + ", " + tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul","Doe","paul@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated Id: " + tempStudent.getId());

	}
}
