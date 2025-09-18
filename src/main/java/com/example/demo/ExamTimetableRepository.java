package com.example.demo;

import com.example.demo.entity.ExamTimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamTimetableRepository extends JpaRepository<ExamTimetableEntry, Long> {
}
