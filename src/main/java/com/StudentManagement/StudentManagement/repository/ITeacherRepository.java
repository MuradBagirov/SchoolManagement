package com.StudentManagement.StudentManagement.repository;

import com.StudentManagement.StudentManagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Teacher,Long> {
}
