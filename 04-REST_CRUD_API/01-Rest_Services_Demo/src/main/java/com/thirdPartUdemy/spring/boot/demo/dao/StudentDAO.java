package com.thirdPartUdemy.spring.boot.demo.dao;

import com.thirdPartUdemy.spring.boot.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student find(Integer id);
    void update(Student theStudent);
    List<Student> findAll();

    void delete(Student theStudent);
}
