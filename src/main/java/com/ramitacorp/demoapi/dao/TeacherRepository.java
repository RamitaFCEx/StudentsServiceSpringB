package com.ramitacorp.demoapi.dao;

import com.ramitacorp.demoapi.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "teachers")
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
