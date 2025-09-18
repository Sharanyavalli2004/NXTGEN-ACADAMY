package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentDashboardController {

    @GetMapping("/studentdashboard")
    public String studentDashboard() {
        return "home/studentdashboard";
    }

    @GetMapping("/student-attendence")
    public String studentAttendence() {
        return "home/student-attendence";
    }

    @GetMapping("/student-timetable")
    public String studentTimetable() {
        return "home/student-timetable";
    }

    @GetMapping("/student-examinations")
    public String studentExaminations() {
        return "home/student-examinations";
    }
}
