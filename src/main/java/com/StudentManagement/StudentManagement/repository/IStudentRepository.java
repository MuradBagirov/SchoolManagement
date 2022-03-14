package com.StudentManagement.StudentManagement.repository;

import com.StudentManagement.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
