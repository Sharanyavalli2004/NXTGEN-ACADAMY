package com.example.demo.repository;

import com.example.demo.entity.TeacherList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherListRepository extends JpaRepository<TeacherList, Long> {
	boolean existsByEmail(String email);
}
