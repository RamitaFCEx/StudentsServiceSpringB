package com.ramitacorp.demoapi.service;
import com.ramitacorp.demoapi.entity.Student;

import java.util.List;

public interface StudentService {

	List<Student> findAll();

	Student findById(int theId);
	
	void save(Student theStudent);
	
	void deleteById(int theId);
	
}
