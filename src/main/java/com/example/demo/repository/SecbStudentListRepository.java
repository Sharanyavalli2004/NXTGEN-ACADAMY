package com.example.demo.repository;

import com.example.demo.entity.SecbStudentList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecbStudentListRepository extends JpaRepository<SecbStudentList, Long> {
	boolean existsByEmail(String email);
}
