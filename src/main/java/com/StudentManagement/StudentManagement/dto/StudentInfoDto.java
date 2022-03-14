package com.StudentManagement.StudentManagement.dto;

import com.StudentManagement.StudentManagement.model.Student;
import com.StudentManagement.StudentManagement.model.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class StudentInfoDto {


    public List<Student>studentList;
    public List<Teacher>teacherList;
    public List<StudentInfoDto>studentInfoList;

}
