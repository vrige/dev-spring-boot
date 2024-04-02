package com.CRUD_REST_API.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CRUD_REST_API.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no need to write any code!
}