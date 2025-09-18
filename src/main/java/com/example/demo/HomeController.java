package com.example.demo;

import com.example.demo.entity.StudentList;
import com.example.demo.entity.TeacherList;
import com.example.demo.repository.StudentListRepository;
import com.example.demo.repository.TeacherListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.demo.repository.SecaStudentListRepository;
import com.example.demo.repository.SecbStudentListRepository;
import com.example.demo.repository.TeacherListRepository;
import com.example.demo.repository.SecaStudentListRepository;
import com.example.demo.repository.SecbStudentListRepository;
import com.example.demo.repository.TeacherListRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private SecaStudentListRepository secaStudentRepo;
    @Autowired 
    private SecbStudentListRepository secbStudentRepo;
    @Autowired 
    private TeacherListRepository teacherRepo;



    @GetMapping("/")
    public String homepage() {
        return "home/homepage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "home/login";
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              @RequestParam("role") String role,
                              Model model) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase(role)) {

            // ✅ Role-based email check
            if ("student".equalsIgnoreCase(role)) {
                boolean inSeca = secaStudentRepo.existsByEmail(email);
                boolean inSecb = secbStudentRepo.existsByEmail(email);
                if (inSeca || inSecb) {
                    return "home/studentdashboard";
                } else {
                    model.addAttribute("error", "You are not registered in SECA or SECB.");
                    return "home/login";
                }

            } else if ("teacher".equalsIgnoreCase(role)) {
                boolean isTeacher = teacherRepo.existsByEmail(email);
                if (isTeacher) {
                    return "home/teacherdashboard";
                } else {
                    model.addAttribute("error", "You are not in the Teacher List.");
                    return "home/login";
                }

            } else if ("parent".equalsIgnoreCase(role)) {
                return "home/parentdashboard";

            } else if ("admin".equalsIgnoreCase(role)) {
                // ✅ Only allow admin login for the fixed email
                if (email.equals("viha@12345") && password.equals("54321")) {
                    return "home/admin-dashboard";
                } else {
                    model.addAttribute("error", "Access denied. Only authorized admin can login.");
                    return "home/login";
                }

            } else {
                model.addAttribute("error", "Unknown role.");
                return "home/login";
            }

        } else {
            model.addAttribute("error", "Invalid credentials.");
            return "home/login";
        }
    }

   

    @GetMapping("/signup")
    public String signupPage() {
        return "home/signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("role") String role,
                               Model model) {

        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("error", "Email already exists!");
            return "home/signup";
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        userRepository.save(user);

        return "redirect:/login";
    }

    @GetMapping("/forgot")
    public String forgotPasswordPage() {
        return "home/forgot";
    }
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String email,
                                @RequestParam("newPassword") String newPassword,
                                @RequestParam("confirmPassword") String confirmPassword,
                                Model model) {
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "home/forgot";
        }

        User user = userRepository.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "User not found!");
            return "home/forgot";
        }

        user.setPassword(newPassword);  // You can add encryption here
        userRepository.save(user);

        model.addAttribute("message", "Password reset successful!");
        return "redirect:/login";
    }


    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "home/dashboard";
    }

    @GetMapping("/teacher/dashboard")
    public String teacherDashboard() {
        return "home/teacherdashboard";
    }

    @GetMapping("/teacher/attendence")
    public String teacherAttendence() {
        return "home/attendence";
    }

    @GetMapping("/teacher/timetable")
    public String teacherTimetable() {
        return "home/timetable";
    }

    @GetMapping("/teacher/examinations")
    public String teacherExaminations() {
        return "home/examinations";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "home/admin-dashboard";
    }

   
} 