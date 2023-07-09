package com.ramitacorp.demoapi.rest;

import com.ramitacorp.demoapi.dao.StudentService;
import com.ramitacorp.demoapi.entity.Student;
import com.ramitacorp.demoapi.exceptions.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    StudentService studentService;

    StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> answer = studentService.findAll();

        if (answer.isEmpty()){
            throw new StudentNotFoundException("Non Student have been found");
        }

        return answer;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        Student answer = studentService.findById(studentId);

        if (answer == null){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return answer;
    }



}
