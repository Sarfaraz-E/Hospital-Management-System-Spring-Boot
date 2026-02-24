package com.example.Hospital_Management_System_Spring_Jpa.service;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Insurance;
import com.example.Hospital_Management_System_Spring_Jpa.entity.Patient;
import com.example.Hospital_Management_System_Spring_Jpa.repository.InsuranceRepository;
import com.example.Hospital_Management_System_Spring_Jpa.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsurenceService {

    private final InsuranceRepository insurenceRepository;  //Final Due to Required ArgsConstructor
    private final PatientRepository patientRepository;


    @Transactional //If all steps will run elase no output will work
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient Not Found with id:" + patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //for bidirectinal consistency maintenence


        return patient;
    }


    @Transactional
    public Patient disAssociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id:" + patientId));
        patient.setInsurance(null); //Here patient will dirty so

        return patient;
    }

}
