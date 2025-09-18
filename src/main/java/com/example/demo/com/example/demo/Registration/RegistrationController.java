package com.example.demo.com.example.demo.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.com.example.demo.Student.Student;
import com.example.demo.com.example.demo.Student.StudentService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showRegistrationForm() {
        return "register"; // Thymeleaf or HTML file name for registration page (register.html)
    }

    @PostMapping
    public String registerNewStudent(@ModelAttribute("user") Student student) {
        studentService.addNewStudent(student);
        return "redirect:/login"; // Redirect to login page after successful registration
    }
}
