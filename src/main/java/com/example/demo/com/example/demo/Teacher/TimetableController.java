package com.example.demo.com.example.demo.Teacher;

import com.example.demo.TimetableRepository;
import com.example.demo.entity.TimetableEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*")
public class TimetableController {

    private final TimetableRepository timetableRepository;

    @Autowired
    public TimetableController(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    // 🔽 Used by teacher to save timetable
    @PostMapping("/saveTimetable")
    public String saveTimetable(@RequestBody List<TimetableEntry> timetableEntries) {
        if (timetableEntries == null || timetableEntries.isEmpty()) {
            return "No timetable data provided";
        }

        timetableRepository.deleteAll(); // optional: replace old timetable
        timetableRepository.saveAll(timetableEntries);
        return "Timetable saved successfully";
    }

    // 🔽 Used by all dashboards (teacher, student, parent)
    @GetMapping("/getTimetable")
    public List<TimetableEntry> getTimetable() {
        return timetableRepository.findAll();
    }

    // Optional: extra aliases for frontend flexibility
    @GetMapping("/student/getTimetable")
    public List<TimetableEntry> getTimetableForStudent() {
        return getTimetable(); // calls shared method
    }

    @GetMapping("/parent/getTimetable")
    public List<TimetableEntry> getTimetableForParent() {
        return getTimetable(); // calls shared method
    }
}
