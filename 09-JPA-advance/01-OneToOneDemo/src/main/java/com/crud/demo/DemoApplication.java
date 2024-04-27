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
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 2;

		System.out.println("Delating instructor detail id: " + id);

		appDAO.deleteInstructorDetailByID(id);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		InstructorDetail TempInstructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("TempInstructorDetail: " + TempInstructorDetail);

		System.out.println("The associated instructorDetail only: " + TempInstructorDetail.getInstructor());

		System.out.println("Done!");

	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finfding instructor id: " + id);

		appDAO.deleteInstrucotrById(id);

		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO){
		int id = 1;

		System.out.println("Finfding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + id);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());

	}
	private void createInstructor(AppDAO appDAO){

		/*
		Instructor tempInstructor = new Instructor("Chad","Darby", "darby@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://something", "Love is important");
		*/
		Instructor tempInstructor = new Instructor("lemu","lano", "lemu@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://lemuSome", "Playing guitar and drums");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
	}
}
