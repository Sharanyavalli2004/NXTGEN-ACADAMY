package com.example.demo.repository;

import com.example.demo.entity.SecaStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecaListRepository extends JpaRepository<SecaStudent, Long> {
}
