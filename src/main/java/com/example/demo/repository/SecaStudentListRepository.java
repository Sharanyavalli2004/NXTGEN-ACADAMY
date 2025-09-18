package com.example.demo.repository;

import com.example.demo.entity.SecaStudentList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecaStudentListRepository extends JpaRepository<SecaStudentList, Long> {
	boolean existsByEmail(String email);
}
