package com.example.demo.attendence;

import com.example.demo.entity.SecaStudent;
import com.example.demo.entity.SecbStudent;
import com.example.demo.entity.SecaRepository;
import com.example.demo.entity.SecbRepository;
import com.example.demo.entity.AttendenceRecord;
import com.example.demo.entity.AttendenceRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/attendance")
@CrossOrigin(origins = "*") // Required if you access this via JS from student/parent dashboards
public class AttendenceController {

    @Autowired
    private SecaRepository secaRepository;

    @Autowired
    private SecbRepository secbRepository;

    @Autowired
    private AttendenceRecordRepository attendenceRepo;

    @GetMapping("/seca")
    public List<SecaStudent> getSecaStudents() {
        return secaRepository.findAll();
    }

    @GetMapping("/secb")
    public List<SecbStudent> getSecbStudents() {
        return secbRepository.findAll();
    }

    @PostMapping("/save")
    public String saveAttendance(@RequestBody List<AttendenceRecord> records) {
        attendenceRepo.saveAll(records);
        return "Attendance saved successfully!";
    }

    // ✅ New GET API to fetch saved attendance for student/parent dashboards
    @GetMapping("/all")
    public List<AttendenceRecord> getAllAttendanceRecords() {
        return attendenceRepo.findAll();
    }
}
