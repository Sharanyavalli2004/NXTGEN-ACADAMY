package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TeacherProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String subject;
    private String customSubject;
    private String experience;
    private String pastSchool;
    private String pastAddress;
    private String pastSubject;
    private String profileImage;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getCustomSubject() { return customSubject; }
    public void setCustomSubject(String customSubject) { this.customSubject = customSubject; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getPastSchool() { return pastSchool; }
    public void setPastSchool(String pastSchool) { this.pastSchool = pastSchool; }

    public String getPastAddress() { return pastAddress; }
    public void setPastAddress(String pastAddress) { this.pastAddress = pastAddress; }

    public String getPastSubject() { return pastSubject; }
    public void setPastSubject(String pastSubject) { this.pastSubject = pastSubject; }

    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
}
