package org.example.tp3.controller;

import org.example.tp3.entities.Patient;
import org.example.tp3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Show all patients
    @GetMapping
    public String showPatients(Model model) {
        List<Patient> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "patients/list";  // Thymeleaf template: patients/list.html
    }

    // Show a form for adding a new patient
    @GetMapping("/new")
    public String showCreatePatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/create";  // Thymeleaf template: patients/create.html
    }

    // Save a new patient
    @PostMapping("/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";  // Redirect to the list page
    }

    // Delete a patient
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";  // Redirect to the list page
    }

    // Search patients by name
    @GetMapping("/search")
    public String searchPatients(@RequestParam String name, Model model) {
        List<Patient> patients = patientService.searchPatientsByName(name);
        model.addAttribute("patients", patients);
        return "patients/list";  // Thymeleaf template: patients/list.html
    }
}
