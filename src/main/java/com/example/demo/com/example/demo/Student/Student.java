package com.example.demo.com.example.demo.Student;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate dob;
    private String major;
    private Integer years;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(Long id, String name, String email, LocalDate dob, String major, Integer years) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.major = major;
        this.years = years;
    }

    // Constructor without ID
    public Student(String name, String email, LocalDate dob, String major, Integer years) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.major = major;
        this.years = years;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    // Computed age based on dob
    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + getAge() +
                ", major='" + major + '\'' +
                ", years=" + years +
                '}';
    }
}
