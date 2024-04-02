package com.thirdPartUdemy.spring.boot.demo.controller;

import com.thirdPartUdemy.spring.boot.demo.dao.StudentDAO;
import com.thirdPartUdemy.spring.boot.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private StudentDAO myStudentDAO;

    public DemoController(StudentDAO studentDAO){
        myStudentDAO = studentDAO;
    }

    @GetMapping("/{someID}")
    public String getNames(@PathVariable(value="someID") Integer id){
        return myStudentDAO.find(id).toString();
    }

    @GetMapping("/findAll")
    public String getAllNames(){
        List<Student> result = myStudentDAO.findAll();
        StringBuilder line = new StringBuilder();
        for(Student e : result){
            line.append(e.toString()).append("\n\n");
        }
        return line.toString();
    }

    @GetMapping("/update/{id}")
    public boolean updateStudent(@PathVariable(value="id") Integer id){
        Student student = myStudentDAO.find(id);
        student.setEmail("Gatto@gmail.com");
        myStudentDAO.update(student);
        return true;
    }

    @GetMapping("/delete/{id}")
    public boolean deleteStudent(@PathVariable(value="id") Integer id){
        Student student = myStudentDAO.find(id);
        myStudentDAO.delete(student);
        return true;
    }
}