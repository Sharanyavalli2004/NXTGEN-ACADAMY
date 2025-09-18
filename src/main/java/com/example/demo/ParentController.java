package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParentController {

    @GetMapping("/parentdashboard")
    public String dashboard() {
        return "home/parentdashboard";
    }

    @GetMapping("/parent-attendance")
    public String attendance() {
        return "home/parent-attendance";
    }

    @GetMapping("/parent-timetable")
    public String timetable() {
        return "home/parent-timetable";
    }

    @GetMapping("/parent-examinations")
    public String examinations() {
        return "home/parent-examinations";
    }
}