package com.StudentManagement.StudentManagement.dto;

import lombok.Data;

import java.util.Date;
@Data
public class TeacherCreateDto{

    private Long passwordNo;
    private String name;
    private String surName;
    private String phoneNumber;
    private String mail;
    private boolean gender;
    private String password;
    private Date recordTime;
    private Long lessonId;
    private Long teacherId;

}
