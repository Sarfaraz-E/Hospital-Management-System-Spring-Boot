package com.example.Hospital_Management_System_Spring_Jpa;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Patient;
import com.example.Hospital_Management_System_Spring_Jpa.repository.PatientRepository;
import com.example.Hospital_Management_System_Spring_Jpa.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository PatientRepository;

    @Autowired
    private PatientService PatientService;

    @Test
    public void testPatientRepository() {
            // 1. Fetch the Page (No casting needed usually)
        //    Pagination most important means load a specific amount  of data from whole data
            Page<Patient> patientPage = PatientRepository.findAllPatients(PageRequest.of(0, 4, Sort.by("name")));

            // 2. Iterate
            for (Patient patient : patientPage) {
                // FIX: Print 'patient', NOT 'patientPage'
                System.out.println(patient);
            }

            // Optional: Print metadata
            System.out.println("Total Pages: " + patientPage.getTotalPages());
            System.out.println("Total Elements: " + patientPage.getTotalElements());
        }


    @Test
    public void testTransationMethods() {
//        Patient Patient1 = PatientService.getPatientByid(14L);
//        System.out.println(Patient1);


//        patient Patient = PatientService.findByName("Adil");
//
//        System.out.println(Patient);

//        List<patient> patientList = PatientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 3, 15), "diya" +
//                ".patel@example.com");
//        List<Patient> patientList = PatientRepository.findByBornAfterDate(LocalDate.of(1993, 3, 14));


//        List<patient> patientList=PatientRepository.findByNameContainingOrderByIdDesc("il");

//        List<patient> patientList2=PatientRepository.findByid(5l);
//                System.out.println(patientList2);

//        List<Patient> patient5 = PatientRepository.findAll();
//        System.out.println(patient5);


//                List<BloodGroupCountResponseEntity> bloodGroupList = PatientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList) {
//            System.out.println(bloodGroupCountResponse);
//        }


//        int rowsUpdated = PatientRepository.updateNameWithId("Sarfaraz",14L);
//        System.out.println(rowsUpdated);

        List<Patient> patients = PatientRepository.findAllPatientWithAppointment();
        System.out.println(patients);

    }
}
