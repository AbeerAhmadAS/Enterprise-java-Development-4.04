package com.lab44.demo.Controller.imp;

import com.lab44.demo.Controller.Detail.EmployeeDTO;
import com.lab44.demo.Controller.Interface.IemployeeController;
import com.lab44.demo.Service.interfacee.IEmployeeService;
import com.lab44.demo.model.Employee;
import com.lab44.demo.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController implements IemployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("/employee")
    public List<Employee> getAllDoctors () {
        return employeeRepository.findAll();
    }


    @GetMapping("/employee/{employeeId}")
    public Employee getDoctorById(@PathVariable Integer employeeId){
        return  iEmployeeService.getDoctorById(employeeId);
    }
    @GetMapping("/employee/status")
    public List<Employee> getDoctorsByStatus(@PathVariable@Valid String status){
        return  employeeRepository.findByStatus(status);
    }@GetMapping("/employee/department")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department){
        return  employeeRepository.findByDepartment(department);
    }
    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveDoctor(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }
    @PatchMapping("/change-status/{employeeStatus}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeStatus(@RequestBody @Valid EmployeeDTO employeeStatusDTO, @PathVariable (name = "employeeId") String status) {
        iEmployeeService.updateEmployeeStatus(employeeStatusDTO.getStatus(), status);
    }

    @PatchMapping("/change-department/{employeeDepartment}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeDepartment(@RequestBody @Valid EmployeeDTO employeeStatusDTO , @PathVariable (name = "employeeId") String employeeDep) {
        iEmployeeService.updateEmployeeDepartment(employeeStatusDTO.getDepartment() ,employeeDep);
    }
}

