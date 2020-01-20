package com.azadibogolubov.aftercodeschool.controller;

import com.azadibogolubov.aftercodeschool.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorsController {
    @Autowired
    ProfessorService professorService;

    @GetMapping(value = "/professors")
    public String getProfessorList() {
        return professorService.getAllProfessors();
    }

    @GetMapping(value = "/professors/{id}")
    public String getProfessor(@PathVariable Integer id) {
        return professorService.getProfessor(id);
    }
}
