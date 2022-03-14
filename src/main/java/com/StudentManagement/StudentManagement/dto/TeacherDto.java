package com.StudentManagement.StudentManagement.dto;

import com.StudentManagement.StudentManagement.model.Lesson;
import com.StudentManagement.StudentManagement.model.Teacher;
import lombok.Data;

import java.util.List;
@Data
public class TeacherDto {
    public List<Teacher> teachers;
    public List<Lesson> lessons;
}
