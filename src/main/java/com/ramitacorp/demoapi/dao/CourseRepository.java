package com.ramitacorp.demoapi.dao;

import com.ramitacorp.demoapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "courses")
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
