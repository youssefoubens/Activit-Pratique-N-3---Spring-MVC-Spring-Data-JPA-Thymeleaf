package org.example.tp3.service;

import org.example.tp3.entities.Patient;
import org.example.tp3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients (without pagination)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patients with pagination
    public Page<Patient> getPatientsPaginated(int page, int size) {
        return patientRepository.findAll(PageRequest.of(page, size));
    }

    // Search patients by name (ignoring case)
    public List<Patient> searchPatientsByName(String name) {
        return patientRepository.findByNomContainingIgnoreCase(name);
    }

    // Delete patient by ID
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Save or update a patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get a patient by ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findAllPatients() {
        return  patientRepository.findAll();
    }
}
