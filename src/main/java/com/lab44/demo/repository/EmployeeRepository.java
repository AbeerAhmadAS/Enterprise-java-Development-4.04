package com.lab44.demo.repository;

import com.lab44.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findByStatus(String status);
    public List<Employee> findByDepartment(String department);



}
