package com.StudentManagement.StudentManagement.dto;

import com.StudentManagement.StudentManagement.model.Lesson;
import lombok.Data;

import java.util.List;
@Data
public class TeacherUpdateDto {
    public TeacherDto teacher;
    public List<Lesson> lessons;
}
