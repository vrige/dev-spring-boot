package com.crud.demo;

import com.crud.demo.dao.AppDAO;
import com.crud.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
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
			//deleteCourse(appDAO);
			//createCourseAndReview(appDAO);
			//retrieveCourseAndReviews(appDAO);
			//deleteCourseAndReview(appDAO);
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//addMoreCoursesForStudent(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int id = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

		Course tempCourse = new Course("LOL - How to do nothing with nothing");
		Course tempCourse1 = new Course("ATARI - 101");
		List<Course> list_courses = new ArrayList<>();
		list_courses.add(tempCourse);
		list_courses.add(tempCourse1);

		tempStudent.setCourses(list_courses);

		System.out.println("Saving student: " + tempStudent);
		System.out.println("Associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");

	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int id = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Loading student: " + tempStudent);
		System.out.println("Associated courses: " + tempStudent.getCourses());

		System.out.println("Done!");

	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int id = 10;
		Course tempCourse = appDAO.findCourseAndStudentByCourseId(id);

		System.out.println("Loading course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done!");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course tempCourse = new Course("PCAMN - How to do nothing with nothing");

		Student tempStudent1 = new Student("John", "doe", "doe@gmail.com");
		Student tempStudent2 = new Student("Mary", "public", "mary@gmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving the course: " + tempCourse);

		appDAO.save(tempCourse);
	}

	private void deleteCourseAndReview(AppDAO appDAO) {

		int id = 10;

		System.out.println("Deleting course id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!");

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int theId = 10 ;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);

		System.out.println(tempCourse);

		System.out.println("Done!");
	}

	private void createCourseAndReview(AppDAO appDAO) {

		Course tempCoruse = new Course("PAMAN - how to score one million points");

		tempCoruse.addReview(new Review("Great course ... love it"));
		tempCoruse.addReview(new Review("Great course ... i like it"));
		tempCoruse.addReview(new Review("what a dumb course!!"));

		System.out.println("Saving the course");

		appDAO.save(tempCoruse);

		System.out.println("Done!");

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
