package com.StudentManagement.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long passportNumber;

    private String name;

    private String surName;

    private Long phoneNumber;

    private String mail;

    private boolean gender;

    private String password;

    @Temporal(TemporalType.DATE)
    private Date recordTime;



    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "manager_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "lesson_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Lesson lesson;

}
