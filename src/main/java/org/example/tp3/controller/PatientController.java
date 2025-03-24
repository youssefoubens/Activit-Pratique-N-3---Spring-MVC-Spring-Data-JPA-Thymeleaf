package org.example.tp3.controller;

import org.example.tp3.entities.Patient;
import org.example.tp3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/patients") // Restricted to users with "USER" role
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Show all patients with pagination
    @GetMapping
    public String showPatients(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size,
            @RequestParam(name = "keyword", defaultValue = "") String kw,
            Model model) {
        Page<Patient> patients = patientService.getPatientsPaginated(page, size, kw);
        model.addAttribute("patients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);

        return "patients/list";  // Thymeleaf template: patients/list.html
    }

    // Show a form for adding a new patient
    @GetMapping("/new")
    public String showCreatePatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/create";  // Thymeleaf template: patients/create.html
    }

    // Redirect root patients URL to list
    @GetMapping("/")
    public String redirectToPatientsList() {
        return "redirect:/user/patients";
    }

    // Save a new patient
    @PostMapping("/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/user/patients";  // Redirect to the list page
    }

    // Delete a patient (Admin-only access)
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/user/patients";  // Redirect to the list page
    }
}
