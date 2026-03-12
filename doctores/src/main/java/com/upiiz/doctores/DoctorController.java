package com.upiiz.doctores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("doctores", repository.findAll());
        return "lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Doctor doctor) {
        repository.save(doctor);
        return "redirect:/doctores";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Doctor doctor = repository.findById(id).orElseThrow();
        model.addAttribute("doctor", doctor);
        return "editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Doctor doctor) {
        repository.save(doctor);
        return "redirect:/doctores";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, Model model) {
        Doctor doctor = repository.findById(id).orElseThrow();
        model.addAttribute("doctor", doctor);
        return "eliminar";
    }


    @PostMapping("/eliminar/{id}")
    public String confirmarEliminar(@PathVariable Integer id) {
        repository.deleteById(id);
        return "redirect:/doctores";
    }
}