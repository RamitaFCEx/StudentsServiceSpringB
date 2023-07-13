package com.ramitacorp.demoapi.controller;

import com.ramitacorp.demoapi.entity.Student;
import com.ramitacorp.demoapi.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    StudentController(StudentServiceImpl theStudentService){
        studentService = theStudentService;
    }

    @GetMapping("/add")
    public String showFormForAdd(Model theModel){

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);
        return "students/student-form";
    }

    @GetMapping("/list")
    public String listStudents(Model theModel){

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students", theStudents);
        return "students/list-students";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("studentId") int studentId, Model theModel){

        Student theStudent = studentService.findById(studentId);

        theModel.addAttribute("student", theStudent);

        return "students/student-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int studentId, Model theModel){
        studentService.deleteById(studentId);
        return "redirect:/students/list";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent){
        studentService.save(theStudent);
        return "redirect:/students/list";
    }



}
