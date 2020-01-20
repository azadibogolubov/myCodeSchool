package com.azadibogolubov.aftercodeschool.service;

import com.azadibogolubov.aftercodeschool.repository.ProfessorRepository;
import com.azadibogolubov.aftercodeschool.model.Professor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public String getAllProfessors() {
        ArrayList<Professor> allProfessors = (ArrayList<Professor>) professorRepository.findAll();
        JSONObject returnObj = new JSONObject();
        JSONArray allProfessorsArr = new JSONArray();
        for (Professor professor: allProfessors) {
            allProfessorsArr.put(new JSONObject(professor));
        }
        returnObj.put("content", allProfessorsArr);

        return returnObj.toString();
    }

    public String getProfessor(Integer id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isPresent()) {
            return new JSONObject(professor.get()).toString();
        } else {
            JSONObject returnObj = new JSONObject();
            returnObj.put("Error", "Invalid ID");
            return returnObj.toString();
        }
    }

    public String addProfessor(Professor professor) {
        Professor savedProfessor = professorRepository.save(professor);
        return new JSONObject(savedProfessor).toString();
    }

    public void deleteProfessor(Integer id) {
        professorRepository.deleteById(id);
    }
}
