package com.example.Hospital_Management_System_Spring_Jpa.repository;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
