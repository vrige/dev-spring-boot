package com.luv2code.springboot.thymeleafApp.dao;

import com.luv2code.springboot.thymeleafApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    // you just need the following line
    public List<Employee> findAllByOrderByLastNameAsc();


}
