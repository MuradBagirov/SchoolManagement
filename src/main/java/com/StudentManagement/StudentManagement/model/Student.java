package com.StudentManagement.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long passwordNumber;

    private String name;

    private String surName;

    private Long schoolNumber;

    private Long schoolClass;

    private Long phoneNumber;

    private String mail;

    private boolean gender;

    private String password;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Manager manager;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentInfo> studentInfoSet = new HashSet<>();

    public Set<StudentInfo> getStudentInfoSet() {
        return studentInfoSet;
    }

    public void setStudentInfoSet(Set<StudentInfo> studentInfoSet) {
        this.studentInfoSet = studentInfoSet;
        for (StudentInfo s : studentInfoSet) {
            s.setStudent(this);
        }

    }
}
