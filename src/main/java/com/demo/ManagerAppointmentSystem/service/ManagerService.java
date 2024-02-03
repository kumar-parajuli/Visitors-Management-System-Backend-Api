package com.demo.ManagerAppointmentSystem.service;
import com.demo.ManagerAppointmentSystem.model.Manager;
import com.demo.ManagerAppointmentSystem.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

@Autowired
    private ManagerRepository managerRepository;

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }
//    public Manager getManagerByFirstname(String firstname) {
//        // Assuming you have a method in your repository to find a manager by firstname
//        return managerRepository.findByFirstName(firstname);
//    }
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }
    public Manager updateManager(Long id, Manager manager) {
        if (managerRepository.existsById(id)) {
            manager.setId(id);
            return managerRepository.save(manager);
        }
        return null;
    }

    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }



}

