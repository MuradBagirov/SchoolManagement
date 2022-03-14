package com.StudentManagement.StudentManagement.repository;

import com.StudentManagement.StudentManagement.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IManagerRepository extends JpaRepository<Manager,Long> {

}
