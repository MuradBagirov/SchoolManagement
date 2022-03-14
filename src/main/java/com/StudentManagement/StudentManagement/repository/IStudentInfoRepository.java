package com.StudentManagement.StudentManagement.repository;

import com.StudentManagement.StudentManagement.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentInfoRepository extends JpaRepository<StudentInfo,Long> {
    @Query(value = "SELECT * FROM studentinfo WHERE student_id=?1",nativeQuery = true)
    List<StudentInfo> findByStudentId(Long student_id);
}
