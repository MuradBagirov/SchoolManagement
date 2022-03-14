package com.StudentManagement.StudentManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lessonName;

    private String rightOfAbsence;

    private int lectureNoteOne;

    private int lectureNoteTwo;

    private int lectureNoteThree;

    private int teacherId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "student_id",nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Student student;

}
