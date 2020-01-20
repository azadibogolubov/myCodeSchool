package com.azadibogolubov.aftercodeschool.service;

import com.azadibogolubov.aftercodeschool.model.Professor;
import com.azadibogolubov.aftercodeschool.repository.StudentRepository;
import com.azadibogolubov.aftercodeschool.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String getAllStudents() {
        ArrayList<Student> allStudents = (ArrayList<Student>) studentRepository.findAll();
        JSONObject returnObj = new JSONObject();
        JSONArray allStudentsArr = new JSONArray();
        for (Student student: allStudents) {
            allStudentsArr.put(new JSONObject(student));
        }
        returnObj.put("content", allStudentsArr);

        return returnObj.toString();
    }

    public String getStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return new JSONObject(student.get()).toString();
        } else {
            JSONObject returnObj = new JSONObject();
            returnObj.put("Error", "Invalid ID");
            return returnObj.toString();
        }
    }

    public String addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return new JSONObject(savedStudent).toString();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
