package com.StudentManagement.StudentManagement.serviceImpl;

import com.StudentManagement.StudentManagement.model.StudentInfo;
import com.StudentManagement.StudentManagement.repository.IStudentInfoRepository;
import com.StudentManagement.StudentManagement.service.IStudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IStudentInfoServiceImpl implements IStudentInfoService {
    private final IStudentInfoRepository studentInfoRepository;

    @Override
    public List<StudentInfo> getAllStudentInfo() {
        return studentInfoRepository.findAll();
    }

    @Override
    public StudentInfo saveStudentInfo(StudentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }

    @Override
    public StudentInfo getStudentInfoById(Long id) {
        return studentInfoRepository.findById(id).get();
    }

    @Override
    public StudentInfo updateStudent(StudentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }

    @Override
    public void deleteStudentInfoById(Long id) {
        studentInfoRepository.deleteById(id);
    }

    @Override
    public List<StudentInfo> getStudentInfoByStudentId(Long student_id) {
        return studentInfoRepository.findByStudentId(student_id);
    }
}
