package com.example.Hospital_Management_System_Spring_Jpa.repository;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
