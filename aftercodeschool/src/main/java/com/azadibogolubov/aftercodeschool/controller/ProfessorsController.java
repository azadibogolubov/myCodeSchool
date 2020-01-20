package com.azadibogolubov.aftercodeschool.controller;

import com.azadibogolubov.aftercodeschool.annotations.JsonGetMapping;
import com.azadibogolubov.aftercodeschool.annotations.JsonPostMapping;
import com.azadibogolubov.aftercodeschool.model.Professor;
import com.azadibogolubov.aftercodeschool.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {
    @Autowired
    ProfessorService professorService;

    @JsonGetMapping(value = "/professors")
    public String getProfessorList() {
        return professorService.getAllProfessors();
    }

    @JsonGetMapping(value = "/professors/{id}")
    public String getProfessor(@PathVariable Integer id) {
        return professorService.getProfessor(id);
    }

    @JsonPostMapping(value = "professors")
    public String addProfessor(@RequestBody Professor professor) {
        return professorService.addProfessor(professor);
    }

    @DeleteMapping(value = "/professors/{id}")
    public void deleteProfessor(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
    }
}
