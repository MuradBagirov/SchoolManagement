package com.StudentManagement.StudentManagement.serviceImpl;

import com.StudentManagement.StudentManagement.model.Lesson;
import com.StudentManagement.StudentManagement.repository.ILessonRepository;
import com.StudentManagement.StudentManagement.service.ILessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ILessonServiceImpl implements ILessonService {
    private final ILessonRepository lessonRepository;

    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson lessonById(Long id) {
        return lessonRepository.getById(id);
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteLessonByID(Long id) {
        lessonRepository.deleteById(id);
    }
}
