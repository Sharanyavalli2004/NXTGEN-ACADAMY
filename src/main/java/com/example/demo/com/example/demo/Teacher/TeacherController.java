package com.example.demo.com.example.demo.Teacher;

import com.example.demo.entity.TeacherProfileRepository;
import com.example.demo.entity.TeacherProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherProfileRepository profileRepository;

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        Teacher teacher = teacherRepository.findById(1L).orElse(new Teacher()); // Hardcoded teacher ID for demo
        TeacherProfile profile = profileRepository.findById(1L).orElse(new TeacherProfile());

        model.addAttribute("teacher", teacher);
        model.addAttribute("profile", profile);
        model.addAttribute("editMode", false); // resume format mode
        return "home/profile"; // ✅ Corrected path
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model) {
        Teacher teacher = teacherRepository.findById(1L).orElse(new Teacher());
        TeacherProfile profile = profileRepository.findById(1L).orElse(new TeacherProfile());

        model.addAttribute("teacher", teacher);
        model.addAttribute("profile", profile);
        model.addAttribute("editMode", true); // form edit mode
        return "home/profile"; // ✅ Corrected path
    }

    @PostMapping("/profile/save")
    public String saveProfile(@ModelAttribute("teacher") Teacher teacher,
                              @ModelAttribute("profile") TeacherProfile profile,
                              Model model) {
        teacherRepository.save(teacher);
        profileRepository.save(profile);
        return "redirect:/teacher/profile"; // ✅ works fine
    }
}
