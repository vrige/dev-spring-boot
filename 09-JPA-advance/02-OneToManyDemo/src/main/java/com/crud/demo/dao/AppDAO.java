package com.crud.demo.dao;

import com.crud.demo.entity.Course;
import com.crud.demo.entity.Instructor;
import com.crud.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstrucotrById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailByID(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor tempInstructor);

    void updateCourse(Course tempCourse);

    Course findCourseById(int id);

    void deleteCourseById(int id);
}
