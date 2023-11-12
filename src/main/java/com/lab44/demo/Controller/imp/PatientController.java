package com.lab44.demo.Controller.imp;

import com.lab44.demo.Controller.Interface.IpatirntController;
import com.lab44.demo.Service.interfacee.IpatientService;
import com.lab44.demo.model.Patient;
import com.lab44.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController implements IpatirntController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    IpatientService ipatientService;
    @Override
    @GetMapping("/patient")
    public List<Patient> getAllPatient () {
        return patientRepository.findAll();
    }
    @Override
    @GetMapping("/patient/{patientId}")
    public Patient getPatientById(@PathVariable Integer patientId){
        return ipatientService.getPatientById(patientId);
    }
    @Override
    @GetMapping("/patient/birthday")
    public List<Patient> getPatientByDateOfBirthRange(
            @RequestParam(defaultValue = "1970-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startRange,
            @RequestParam (defaultValue = "2000-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endRange
    ){
        return patientRepository.findByDateOfBirthBetween(startRange,endRange);
    }
    @Override
    @GetMapping("/patient/department/{department}")
    public List<Patient> getPatientByEmployeeDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @Override
    @GetMapping("/patient/off-status")
    public List<Patient> getPatientWithEmployeeStatusOFF() {
        return patientRepository.findByAdmittedByStatus("OFF");
    }

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void savePatient(@RequestBody Patient patient){
        patientRepository.save(patient);
    }
}
