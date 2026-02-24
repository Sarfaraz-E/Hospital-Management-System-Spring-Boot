package com.example.Hospital_Management_System_Spring_Jpa.service;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Appointment;
import com.example.Hospital_Management_System_Spring_Jpa.entity.Doctor;
import com.example.Hospital_Management_System_Spring_Jpa.entity.Patient;
import com.example.Hospital_Management_System_Spring_Jpa.repository.AppointmentRepository;
import com.example.Hospital_Management_System_Spring_Jpa.repository.DoctorRepository;
import com.example.Hospital_Management_System_Spring_Jpa.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppoinment(Appointment appointment,Long doctorId,Long patientId){

        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have ");

        // Will update appointment from following code
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

       //For  maintaning Bi  directional consistency can see appointment from doctor table
        patient.getAppointments().add(appointment);

        //For save this appointment and  showing
       return  appointmentRepository.save(appointment);

    }

    @Transactional
    public  Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment =appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); //THis will automatically call the update because of dirty checking

        doctor.getAppointments().add(appointment); // just for Bidirectional consistency
        return appointment;
    }
}
