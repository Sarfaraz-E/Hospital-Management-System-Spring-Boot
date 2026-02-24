package com.example.Hospital_Management_System_Spring_Jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false,unique = true, length = 100)
    private String email;


    //to make the biderectional mapping between doctor and department
    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments= new HashSet<>();


    @OneToMany(mappedBy = "doctor") //For Bi directional Mapping one appointment can assign to many doctors
    private List<Appointment> appointments =new ArrayList<>();
}
