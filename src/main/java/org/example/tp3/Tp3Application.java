package org.example.tp3;

import org.example.tp3.entities.Patient;
import org.example.tp3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Tp3Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Using the Builder pattern to create patients
        Patient patient1 = Patient.builder()
                .name("John Doe")
                .dateNaissance(LocalDate.of(1985, 5, 15))
                .malade(true)
                .score(80)
                .build();

        Patient patient2 = Patient.builder()
                .name("Jane Smith")
                .dateNaissance(LocalDate.of(1990, 8, 25))
                .malade(false)
                .score(90)
                .build();

        Patient patient3 = Patient.builder()
                .name("Michael Johnson")
                .dateNaissance(LocalDate.of(2000, 11, 10))
                .malade(true)
                .score(70)
                .build();
        Patient patient4 = Patient.builder()
                .name("Michael Johnson")
                .dateNaissance(LocalDate.of(2000, 11, 10))
                .malade(true)
                .score(70)
                .build();

        // Saving the patients to the database
        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);

        System.out.println("Sample patients added to the database!");
  }


}
