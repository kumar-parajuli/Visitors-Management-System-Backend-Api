package com.demo.ManagerAppointmentSystem.service;

import com.demo.ManagerAppointmentSystem.model.Visitor;
import com.demo.ManagerAppointmentSystem.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisitorService {



    @Autowired
    private VisitorRepository visitorRepository;
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getVisitorById(Long id) {
        return visitorRepository.findById(id).orElse(null);
    }

    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
//    public Visitor getVisitorByFirstname(String firstname) {
//        return visitorRepository.findByFirstName(firstname);
//    }
    public Visitor updateVisitor(Long id, Visitor visitor) {
        if (visitorRepository.existsById(id)) {
            visitor.setId(id);
            return visitorRepository.save(visitor);
        }
        return null;
    }

    public void deleteVisitor(Long id) {
        visitorRepository.deleteById(id);
    }



    }

