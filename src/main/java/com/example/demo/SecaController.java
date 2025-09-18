package com.example.demo;

import com.example.demo.entity.SecaStudent;
import com.example.demo.repository.SecaListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/seca")
@CrossOrigin(origins = "*")
public class SecaController {

    @Autowired
    private SecaListRepository secaRepo;

    @GetMapping("/list")
    public List<SecaStudent> getAll() {
        return secaRepo.findAll();
    }

    @PostMapping("/save")
    public String saveAll(@RequestBody List<SecaStudent> students) {
        secaRepo.deleteAll(); // Optional: Clear old data
        secaRepo.saveAll(students);
        return "SECA Students saved successfully!";
    }
}
