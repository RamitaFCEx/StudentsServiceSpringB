package com.ramitacorp.demoapi.dao;

import com.ramitacorp.demoapi.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    @Transactional
    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
