package com.StudentManagement.StudentManagement.service;

import com.StudentManagement.StudentManagement.model.Student;

import java.util.List;

public interface IStudentService  {
    List<Student>getAllStudent();

    Student save(Student student);


    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
