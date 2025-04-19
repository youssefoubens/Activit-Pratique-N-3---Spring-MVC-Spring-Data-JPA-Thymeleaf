package org.example.tp3.controller;

import org.example.tp3.entities.Patient;
import org.example.tp3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/user/patients")
    public String showPatients(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size,
            @RequestParam(name = "keyword", defaultValue = "") String kw,
            Model model) {
        Page<Patient> patients = patientService.getPatientsPaginated(page, size, kw);
        model.addAttribute("patients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);  // Added to preserve search keyword
        model.addAttribute("size", size);
        return "patients/list";
    }

    @GetMapping("/user/new")
    public String showCreatePatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/create";
    }

    @PostMapping("/user/patients/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/user/patients";
    }

    @GetMapping("/user/delete/{id}")
    public String deletePatient(@PathVariable Long id,
                                @RequestParam(name = "keyword", defaultValue = "") String keyword,
                                @RequestParam(name = "page", defaultValue = "0") int page) {
        patientService.deletePatient(id);
        return "redirect:/user/patients?page=" + page + "&keyword=" + keyword;  // Preserve pagination and search
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/user/patients";
    }

    @GetMapping("/patients")
    public String redirectPatients() {
        return "redirect:/user/patients";
    }
}