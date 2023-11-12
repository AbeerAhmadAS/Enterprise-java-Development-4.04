package com.lab44.demo.Controller.Interface;

import com.lab44.demo.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface IpatirntController {
    public List<Patient> getAllPatient ();
    public Patient getPatientById( Integer patientId);
    public List<Patient> getPatientByDateOfBirthRange(LocalDate startRange, LocalDate endRange);
    public List<Patient> getPatientByEmployeeDepartment(String department);
    public List<Patient> getPatientWithEmployeeStatusOFF();
    public void savePatient( Patient patient);


}