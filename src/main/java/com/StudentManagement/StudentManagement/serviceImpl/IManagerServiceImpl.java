package com.StudentManagement.StudentManagement.serviceImpl;

import com.StudentManagement.StudentManagement.model.Manager;
import com.StudentManagement.StudentManagement.repository.IManagerRepository;
import com.StudentManagement.StudentManagement.service.IManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IManagerServiceImpl implements IManagerService {
    private final IManagerRepository managerRepository;


    @Override
    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager getManagerById(Long id) {
        return managerRepository.getById(id);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }
}
