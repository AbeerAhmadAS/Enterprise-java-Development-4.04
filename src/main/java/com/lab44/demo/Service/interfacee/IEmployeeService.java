package com.lab44.demo.Service.interfacee;

import com.lab44.demo.Controller.Detail.EmployeeDTO;
import com.lab44.demo.model.Employee;

public interface IEmployeeService  {

    public Employee getDoctorById(Integer employeeId);


     void updateEmployeeStatus(String status, String status1);

     void updateEmployeeDepartment(String employeeDep, String employeeDep1);
}
