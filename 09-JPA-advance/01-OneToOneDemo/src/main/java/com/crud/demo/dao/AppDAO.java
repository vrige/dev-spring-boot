package com.crud.demo.dao;

import com.crud.demo.entity.Instructor;
import com.crud.demo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstrucotrById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailByID(int id);
}
