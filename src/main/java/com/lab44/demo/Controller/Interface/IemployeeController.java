package com.lab44.demo.Controller.Interface;

import com.lab44.demo.Controller.Detail.EmployeeDTO;
import com.lab44.demo.model.Employee;

import java.util.List;

public interface IemployeeController {
    public List<Employee> getAllDoctors ();
    public Employee getDoctorById (Integer employeeId);
    public List<Employee> getDoctorsByStatus( String status);
    public List<Employee> getDoctorsByDepartment(String department);
    public void saveDoctor( Employee employee);

}
