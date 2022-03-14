package com.StudentManagement.StudentManagement.service;

import com.StudentManagement.StudentManagement.model.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson>getAllLesson();
    Lesson save(Lesson lesson);
    Lesson lessonById(Long id);
    Lesson updateLesson(Lesson lesson);
    void deleteLessonByID(Long id);
}
