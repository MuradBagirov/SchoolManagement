package com.StudentManagement.StudentManagement.repository;

import com.StudentManagement.StudentManagement.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILessonRepository extends JpaRepository<Lesson,Long> {
}
