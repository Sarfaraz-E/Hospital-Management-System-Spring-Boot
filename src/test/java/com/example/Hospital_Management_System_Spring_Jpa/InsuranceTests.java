package com.example.Hospital_Management_System_Spring_Jpa;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Insurance;
import com.example.Hospital_Management_System_Spring_Jpa.entity.Patient;
import com.example.Hospital_Management_System_Spring_Jpa.service.InsurenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsurenceService insurenceService;

    @Test
    public void testInsurance(){

        Insurance insurance= Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HBL")
                .validUntil(LocalDate.from(LocalDate.of(2030,12,12)).atStartOfDay())
                .build();

        Patient patient = insurenceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);


        var newPatient = insurenceService.disAssociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);

    }
}
