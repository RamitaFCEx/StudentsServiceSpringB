package com.ramitacorp.demoapi.dao;

import com.ramitacorp.demoapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByLastName(String theLastName);

    List<Student> findAllByOrderByLastName();
}
