package com.thirdPartUdemy.spring.boot.demo.dao;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.thirdPartUdemy.spring.boot.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.lang.model.type.NullType;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student find(Integer id){
        return entityManager.find(Student.class, id);

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Student theStudent) {
        entityManager.remove(theStudent);
    }
}