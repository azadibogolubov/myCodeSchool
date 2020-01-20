package com.azadibogolubov.aftercodeschool.controller;

import com.azadibogolubov.aftercodeschool.annotations.JsonGetMapping;
import com.azadibogolubov.aftercodeschool.annotations.JsonPostMapping;
import com.azadibogolubov.aftercodeschool.model.Student;
import com.azadibogolubov.aftercodeschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @JsonGetMapping(value = "/students")
    public String getStudentList() {
        return studentService.getAllStudents();
    }

    @JsonGetMapping(value = "/students/{id}")
    public String getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @JsonPostMapping(value = "/students")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
