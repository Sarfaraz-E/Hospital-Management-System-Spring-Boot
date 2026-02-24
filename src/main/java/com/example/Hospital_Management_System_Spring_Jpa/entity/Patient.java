package com.example.Hospital_Management_System_Spring_Jpa.entity;

import com.example.Hospital_Management_System_Spring_Jpa.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
  @Entity
  @Getter
  @Setter
  @Table(
          name = "Patient",
          uniqueConstraints ={
//                  @UniqueConstraint( name = "unique_patient_email", columnNames = {"email"}),
                  @UniqueConstraint(name = "unique_patient_name_birthdate",columnNames = {"name","birthDate"})
          },
          indexes = {
                  @Index(name = "idx_patient_birth_date", columnList = "birthDate")
          }
  )
public class Patient {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;


     @CreationTimestamp
      @Column(updatable = false)
      private LocalDateTime createdAt;

    //    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;


    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;




    //Associating Insurance Entity
    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true) //For change  in child table with change in father table if  patient will delete his insurence will be also delete
     //CascadeType.PERSIST: for propgate persist (save) operation.
    // CascadeType.MERGE:   for propagate merge(update) operation.
    // CascadeType.REMOVE:  for propagate remove(delete) operation.
    //CascadeType.REFRESH:  for propagate refresh operation.
    //CascadeType.DETACH:  for propagate detach operation.
    //CascadeType.ALL:  for propagate all operations (PERSIST,MERGE,REMOVE,REFRESH,DETACH).



    //Now  For  Orphan Removal
//    For @OneToMany: When an entity is removed from the collection (eg.list.remove(),clear,or reassign a new collection)
//   For  @OneToOne : when the reference is  set to null or replaced with a new entity.

//    main diff bw both is:
//    we want that all child  will delete automatic with parent use  CascadeType
//    we want that parent will not delete but child will delete Automatically when no  longer is referenced by  parrent
//    eg:
    // Cascading is not defined because we dont want to delete patient with appointment deletion or not want to delete doctor along with

    @JoinColumn(name = "patient_insurence_id")// owning Side
    private Insurance insurance;


    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE},orphanRemoval = true, fetch = FetchType.EAGER) // .EAGER when want patient dont bring Appointment or ignore to Appointment
    //orphanRemoval mean any chield dont have Parent will remove automatically from memory here if patient will delete its appointment will delete automatically
    private List<Appointment> appointments=new ArrayList<>();

}
