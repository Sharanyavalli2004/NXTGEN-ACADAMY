package com.example.demo;

import com.example.demo.entity.TimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<TimetableEntry, Long> {
}
