package com.ramitacorp.demoapi.rest;

import com.ramitacorp.demoapi.dao.StudentService;
import com.ramitacorp.demoapi.entity.Student;
import com.ramitacorp.demoapi.exceptions.StudentErrorResponse;
import com.ramitacorp.demoapi.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    StudentService studentService;

    StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(LocalDateTime.now());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(LocalDateTime.now());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
