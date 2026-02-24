package com.example.Hospital_Management_System_Spring_Jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany  //will create a join table between doctor and department auto
    @JoinTable(
            name = "my_dpt_doctors",
            joinColumns = @JoinColumn(name="dept_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")

    )
    private Set<Doctor> doctors = new HashSet<>();

}
