package com.example.demo.com.example.demo.Teacher;

import com.example.demo.entity.ExamTimetableEntry;
import com.example.demo.ExamTimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/examinations")
@CrossOrigin(origins = "*") // Required if called via JavaScript from student/parent pages
public class ExamTimetableController {

    @Autowired
    private ExamTimetableRepository repository;

    @PostMapping("/save")
    public String saveExaminations(@RequestBody List<ExamTimetableEntry> exams) {
        repository.deleteAll(); // Clear old exams
        repository.saveAll(exams);
        return "Examinations saved successfully!";
    }

    // Fetch for teacher dashboard (already existing)
    @GetMapping("/list")
    public List<ExamTimetableEntry> getAllExams() {
        return repository.findAll();
    }

    // ✅ New endpoint for student/parent dashboards
    @GetMapping("/all")
    public List<ExamTimetableEntry> getExamTimetableForStudentsAndParents() {
        return repository.findAll();
    }
}
