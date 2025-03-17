package org.example.tp3.repository;

import org.example.tp3.entities.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientrepository extends JpaRepository<patient,Long> {
}
