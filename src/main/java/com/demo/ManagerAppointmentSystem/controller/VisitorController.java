package com.demo.ManagerAppointmentSystem.controller;

import com.demo.ManagerAppointmentSystem.command.VisitorCommand;


import com.demo.ManagerAppointmentSystem.model.Visitor;
import com.demo.ManagerAppointmentSystem.repository.VisitorRepository;
import com.demo.ManagerAppointmentSystem.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;

@Autowired
private ManagerService managerService;
    // Create a new visitor
    @PostMapping("/add-visitor")
    public ResponseEntity<Visitor> addVisitor(@RequestBody VisitorCommand visitorCommand) {
        if(visitorCommand == null)
            return null;

        Visitor visitor = new Visitor();
        visitor.setFirstName(visitorCommand.getFirstName());
        visitor.setLastName(visitorCommand.getLastName());
        visitor.setEmail(visitorCommand.getEmail());
        visitor.setPhoneNumber(visitorCommand.getPhoneNumber());
        visitor.setAddress(visitorCommand.getAddress());
        visitor.setGender(visitorCommand.getGender());
        Visitor savedVisitor = visitorRepository.save(visitor);
        return new ResponseEntity<>(savedVisitor, HttpStatus.CREATED);
    }
//    Visitor addedVisitor =visitorServices.addVisitor(visitor);
//        return new ResponseEntity<>(addedVisitor, HttpStatus.CREATED);
    // Retrieve all visitors
    @GetMapping
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        List<Visitor> visitors = visitorRepository.findAll();
        if (visitors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    // Retrieve a single visitor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {
        Optional<Visitor> visitor = visitorRepository.findById(id);
        return visitor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a visitor by ID
    @PutMapping("/update-visitor/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable Long id, @RequestBody Visitor updatedVisitor) {
        Optional<Visitor> existingVisitor = visitorRepository.findById(id);

        if (existingVisitor.isPresent()) {
            Visitor visitor = existingVisitor.get();
            visitor.setFirstName(updatedVisitor.getFirstName());
            visitor.setLastName(updatedVisitor.getLastName());
            visitor.setAddress(updatedVisitor.getAddress());
            visitor.setEmail(updatedVisitor.getEmail());
            visitor.setPhoneNumber(updatedVisitor.getPhoneNumber());
            visitor.setGender(updatedVisitor.getGender());

            return new ResponseEntity<>(visitorRepository.save(visitor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a visitor by ID
    @DeleteMapping("/delete-visitor/{visitorId}")
    public ResponseEntity<HttpStatus> deleteVisitor(@PathVariable Long visitorId) {
        try {
            visitorRepository.deleteById(visitorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

