package com.example.demo;

import com.example.demo.entity.*;

import com.example.demo.repository.*;
import com.example.demo.dto.StudentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired private SecaStudentListRepository secaStudentRepo;
    @Autowired private SecbStudentListRepository secbStudentRepo;
    @Autowired private TeacherListRepository teacherRepo;

    // ✅ SAVE STUDENTS (SECA / SECB) — Appends instead of deleting
    @PostMapping("/saveStudents")
    public ResponseEntity<String> saveStudents(@RequestParam String section, @RequestBody List<StudentDTO> students) {
        try {
            if ("SECA".equalsIgnoreCase(section)) {
                List<SecaStudentList> secaStudents = students.stream().map(s -> {
                    SecaStudentList seca = new SecaStudentList();
                    seca.setName(s.getName());
                    seca.setEmail(s.getEmail());
                    return seca;
                }).toList();
                secaStudentRepo.saveAll(secaStudents);
            } else if ("SECB".equalsIgnoreCase(section)) {
                List<SecbStudentList> secbStudents = students.stream().map(s -> {
                    SecbStudentList secb = new SecbStudentList();
                    secb.setName(s.getName());
                    secb.setEmail(s.getEmail());
                    return secb;
                }).toList();
                secbStudentRepo.saveAll(secbStudents);
            } else {
                return ResponseEntity.badRequest().body("Unknown section: " + section);
            }
            return ResponseEntity.ok("Students appended to section: " + section);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to save students: " + e.getMessage());
        }
    }

    // ✅ GET STUDENTS (SECA / SECB)
    @GetMapping("/getStudents")
    public ResponseEntity<List<?>> getStudents(@RequestParam String section) {
        try {
            if ("SECA".equalsIgnoreCase(section)) {
                return ResponseEntity.ok(secaStudentRepo.findAll());
            } else if ("SECB".equalsIgnoreCase(section)) {
                return ResponseEntity.ok(secbStudentRepo.findAll());
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // ✅ DELETE STUDENT (SECA / SECB)
    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam String section, @RequestParam Long id) {
        try {
            if ("SECA".equalsIgnoreCase(section)) {
                secaStudentRepo.deleteById(id);
            } else if ("SECB".equalsIgnoreCase(section)) {
                secbStudentRepo.deleteById(id);
            } else {
                return ResponseEntity.badRequest().body("Invalid section");
            }
            return ResponseEntity.ok("Student deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to delete student: " + e.getMessage());
        }
    }

    // ✅ SAVE TEACHERS — (still clears and saves new list)
    @PostMapping("/saveTeachers")
    public ResponseEntity<String> saveTeachers(@RequestBody List<TeacherList> teachers) {
        try {
           
            teacherRepo.saveAll(teachers);
            return ResponseEntity.ok("Teachers saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to save teachers: " + e.getMessage());
        }
    }

    // ✅ GET TEACHERS
    @GetMapping("/getTeachers")
    public ResponseEntity<List<TeacherList>> getTeachers() {
        try {
            return ResponseEntity.ok(teacherRepo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // ✅ DELETE TEACHER BY ID
    @DeleteMapping("/deleteTeacher")
    public ResponseEntity<String> deleteTeacher(@RequestParam Long id) {
        try {
            teacherRepo.deleteById(id);
            return ResponseEntity.ok("Teacher deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to delete teacher.");
        }
    }
}
