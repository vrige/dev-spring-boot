package com.crud.demo.dao;

import com.crud.demo.entity.Course;
import com.crud.demo.entity.Instructor;
import com.crud.demo.entity.InstructorDetail;
import com.crud.demo.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        // if you CascadeType.ALL, then all aso "InstrucotrDetail" will be saved
        entityManager.persist(theInstructor);
    }

    // you will find also the associated class because of @OneToOne
    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstrucotrById(int id) {

        Instructor instructor = entityManager.find(Instructor.class, id);

        // remove the instructor from its classes
        List<Course> courses = instructor.getCourseList();

        for(Course course : courses){
            course.setInstructor(null);
        }

        // it deletes also the associated course detail object from the db
        entityManager.remove(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailByID(int id) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                   "JOIN FETCH i.courseList " +
                   "JOIN FETCH i.instructorDetail " +
                   "where i.id = :data", Instructor.class
        );

        query.setParameter("data", id);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {

        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course tempCourse = findCourseById(id);

        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        // it will save also the reviews (because of cascade)
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                 "select c from Course c " +
                    "JOIN FETCH c.reviews " +
                    "where c.id = :data", Course.class
        );

        query.setParameter("data", id);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.students " +
                        "where c.id = :data", Course.class
        );

        query.setParameter("data", id);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s " +
                        "JOIN FETCH s.courses " +
                        "where s.id = :data", Student.class
        );

        query.setParameter("data", id);

        Student student = query.getSingleResult();

        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}