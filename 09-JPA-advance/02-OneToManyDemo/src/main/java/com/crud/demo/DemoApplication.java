package com.crud.demo;

import com.crud.demo.dao.AppDAO;
import com.crud.demo.entity.Course;
import com.crud.demo.entity.Instructor;
import com.crud.demo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstrucotrWithCourses(appDAO);
			//findCourseForInstructor(appDAO);
			//findIstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			//updateCourse(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {

		int id = 10;

		System.out.println("Deleting course id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!");

	}

	private void updateCourse(AppDAO appDAO){
		int tempId = 10;

		System.out.println("Finding course id: " + tempId);
		Course tempCourse = appDAO.findCourseById(tempId);

		System.out.println("Updating course id: " + tempId);
		tempCourse.setTitle("ENjoy something");

		appDAO.updateCourse(tempCourse);

		System.out.println("Done!");
	}
	private void updateInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("Update instructor id: " + id);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("DONE!");
	}

	private void findIstructorWithCoursesJoinFetch(AppDAO appDAO){

		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("TempInstructor: " + id);
		System.out.println("list of courses: " + tempInstructor.getCourseList());

	}

	private void findCourseForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		tempInstructor.setCourseList(courses);

		System.out.println("list of courses: " + tempInstructor.getCourseList());

	}

	private void findInstrucotrWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated course: " + tempInstructor.getCourseList());
		System.out.println("Done!");

	}
	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Susan","len", "lemu@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://Susan", "Playing guitar and games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse = new Course("Air Guitar - The ultimate guide");
		Course tempCourse2 = new Course("Pinball masterclass");

		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourseList());

		appDAO.save(tempInstructor);
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
