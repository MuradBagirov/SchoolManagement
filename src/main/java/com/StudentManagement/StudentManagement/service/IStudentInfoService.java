package com.StudentManagement.StudentManagement.service;

import com.StudentManagement.StudentManagement.model.StudentInfo;

import java.util.List;

public interface IStudentInfoService {

List<StudentInfo>getAllStudentInfo();
StudentInfo saveStudentInfo(StudentInfo studentInfo);
StudentInfo getStudentInfoById(Long id);
StudentInfo updateStudent(StudentInfo studentInfo);
void deleteStudentInfoById(Long id);
List<StudentInfo>getStudentInfoByStudentId(Long student_id);

}
