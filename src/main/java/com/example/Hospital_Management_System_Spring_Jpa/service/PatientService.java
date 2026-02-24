package com.example.Hospital_Management_System_Spring_Jpa.service;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Patient;
import com.example.Hospital_Management_System_Spring_Jpa.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientrepository;

    @Transactional
    public Patient getPatientByid(Long id) {

        Patient p1 = patientrepository.findById(id).orElseThrow();
        Patient p2 = patientrepository.findById(id).orElseThrow();

        p1.setName("Amir"); //will change due to transation and used getter and setter in Entity class


        return p1;
    }

    public Patient findByName(String name) {
        Patient P1 =patientrepository.findByName(name);
        return P1;
    }


}
