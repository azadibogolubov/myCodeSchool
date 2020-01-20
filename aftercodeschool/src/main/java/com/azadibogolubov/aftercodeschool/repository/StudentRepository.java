package com.azadibogolubov.aftercodeschool.repository;

import com.azadibogolubov.aftercodeschool.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findAll();
}
