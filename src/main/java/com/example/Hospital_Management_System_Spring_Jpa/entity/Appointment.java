package com.example.Hospital_Management_System_Spring_Jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

//    @Column(length = 500)
//    private String status;

    @ManyToOne // Cascading is not defined because we dont want to delete patient with appointment deletion or not want to delete doctor along with
    @ToString.Exclude
    @JoinColumn(name = "patient_id",nullable = false)//patient  is require not  nullable
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(nullable = false) //owning side bc doctor is  independent
    private Doctor doctor;
}
