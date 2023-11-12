package com.lab44.demo.Service.impl;

import com.lab44.demo.Service.interfacee.IpatientService;
import com.lab44.demo.model.Patient;
import com.lab44.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService implements IpatientService {
    PatientRepository patientRepository ;
    public Patient getPatientById(Integer patientId){
        Optional<Patient> patientOptional=patientRepository.findById(patientId);
        if(patientOptional.isEmpty())return  null;
        return patientOptional.get();
    }





}
