package com.lab44.demo.Service.impl;

import com.lab44.demo.Controller.Detail.EmployeeDTO;
import com.lab44.demo.Service.interfacee.IEmployeeService;
import com.lab44.demo.model.Employee;
import com.lab44.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    EmployeeRepository employeeRepository;
    @Override
    public Employee getDoctorById(Integer employeeId){
        Optional<Employee> employeeOptional=employeeRepository.findById(employeeId);
        if(employeeOptional.isEmpty())return  null;
        return employeeOptional.get();

    }



    @Override
    public void updateEmployeeStatus(String status, String status1) {
        List<Employee> employeeStatus=employeeRepository.findByStatus(status1);
        if(employeeStatus.isEmpty())return;


    }

    @Override
    public void updateEmployeeDepartment(String employeeDep, String employeeDep1){
        List<Employee> employeeDepartment=employeeRepository.findByDepartment(employeeDep);
        if(employeeDepartment.isEmpty())return;

    }

}
