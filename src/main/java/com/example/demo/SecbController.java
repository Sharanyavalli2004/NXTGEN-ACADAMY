package com.example.demo;

import com.example.demo.entity.SecbStudent;
import com.example.demo.repository.SecbListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/secb")
@CrossOrigin(origins = "*")
public class SecbController {

    @Autowired
    private SecbListRepository secbRepo;

    @GetMapping("/list")
    public List<SecbStudent> getAll() {
        return secbRepo.findAll();
    }

    @PostMapping("/save")
    public String saveAll(@RequestBody List<SecbStudent> students) {
        secbRepo.deleteAll(); // Optional: Clear old data
        secbRepo.saveAll(students);
        return "SECB Students saved successfully!";
    }
}
