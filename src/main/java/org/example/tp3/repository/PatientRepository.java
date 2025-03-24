package org.example.tp3.repository;

import org.example.tp3.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);
    Page<Patient> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
