package com.thirdPartUdemy.spring.boot.demo.rest;

import com.thirdPartUdemy.spring.boot.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Joe","Dicker","Joe@gmail.com"));
        theStudents.add(new Student("Barbara","Dicker","Barbara@gmail.com"));
        theStudents.add(new Student("Carlo","Eldor","Carlo@gmail.com"));

    }

    @GetMapping("/students/{studentID}")
    public Student getStudents(@PathVariable int studentID){

        if( (studentID >= theStudents.size()) || (studentID < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentID);
        }

        return theStudents.get(studentID);
    }


}