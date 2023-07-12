package com.ramitacorp.demoapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class WebController {
    @GetMapping("/hello")
    public String helloWorld(Model model){
        model.addAttribute("theDate", LocalDateTime.now());
        return "helloWorld";
    }
}
