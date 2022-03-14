package com.StudentManagement.StudentManagement.service;

import com.StudentManagement.StudentManagement.model.Manager;

import java.util.List;

public interface IManagerService {
    List<Manager>getAllManager();
    Manager save(Manager manager);
    Manager getManagerById (Long id);
    Manager updateManager(Manager manager);
    void deleteManagerById(Long id);
}
