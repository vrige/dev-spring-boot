package com.crud.demo.dao;

import com.crud.demo.entity.Instructor;
import com.crud.demo.entity.InstructorDetail;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

        // it deletes also the associated object from the db
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
}