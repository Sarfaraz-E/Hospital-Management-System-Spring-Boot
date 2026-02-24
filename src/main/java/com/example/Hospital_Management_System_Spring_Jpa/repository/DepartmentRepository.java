package com.example.Hospital_Management_System_Spring_Jpa.repository;

import com.example.Hospital_Management_System_Spring_Jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
