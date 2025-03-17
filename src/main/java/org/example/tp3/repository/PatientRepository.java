package org.example.tp3.repository;

import org.example.tp3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByNomContainingIgnoreCase(String name);
}
