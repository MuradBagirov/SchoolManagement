package com.StudentManagement.StudentManagement.serviceImpl;

import com.StudentManagement.StudentManagement.model.Student;
import com.StudentManagement.StudentManagement.repository.IStudentRepository;
import com.StudentManagement.StudentManagement.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IStudentServiceImpl implements IStudentService {
    private final IStudentRepository iStudentRepository;


    @Override
    public List<Student> getAllStudent() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return iStudentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return iStudentRepository.getById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return iStudentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        iStudentRepository.deleteById(id);
    }


}
