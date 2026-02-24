package com.example.Hospital_Management_System_Spring_Jpa.repository;


import com.example.Hospital_Management_System_Spring_Jpa.dto.BloodGroupCountResponseEntity;
import com.example.Hospital_Management_System_Spring_Jpa.entity.Patient;
import com.example.Hospital_Management_System_Spring_Jpa.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    Patient findByEmail(String mail);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String mail);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select new com.example.Hospital_Management_System_Spring_Jpa.dto.BloodGroupCountResponseEntity(p.bloodGroup," +
            " Count(p)) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query("Select p FROM Patient p where p.id= ?1") // <--- Fix: Uppercase 'Patient'
    List<Patient> findByid(@Param("name") Long id);

    @Transactional
    @Modifying
    @Query("Update Patient p  set p.name =:name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

//    Pagination most important means load a specific amount  of data from whole data

    @Query(value = "Select * from patient ", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Patient p set p.name =:name where p.id = :id")
//    int updateNameWithId(@Param("name") String name , @Param("id") Long id);


    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppointment();

}
