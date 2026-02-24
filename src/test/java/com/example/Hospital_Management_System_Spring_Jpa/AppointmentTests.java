package com.example.Hospital_Management_System_Spring_Jpa;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Appointment;
import com.example.Hospital_Management_System_Spring_Jpa.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;


    @Test
    public void testCreateAppointmment(){
        Appointment appointment =Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,22))
                .reason("Skin Alergy")
                .build();

        var newAppointment = appointmentService. createNewAppoinment(appointment,1L,2L);

        System.out.println(newAppointment);




        // Will update appointment to anothher  doctore if one doctor is not availablee
        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),  2L);
        System.out.println(updatedAppointment);


    }
}
