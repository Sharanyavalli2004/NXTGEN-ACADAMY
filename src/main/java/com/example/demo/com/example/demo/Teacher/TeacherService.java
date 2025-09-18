package com.example.demo.com.example.demo.Teacher;

import com.example.demo.entity.TeacherProfile;
import com.example.demo.entity.TeacherProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherProfileRepository teacherProfileRepository;

    public TeacherProfile saveTeacherProfile(TeacherProfile profile) {
        return teacherProfileRepository.save(profile);
    }
}
