package com.azadibogolubov.aftercodeschool.controller;

import com.azadibogolubov.aftercodeschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public String getStudentList() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/students/{id}")
    public String getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }
}
