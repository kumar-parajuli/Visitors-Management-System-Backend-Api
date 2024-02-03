package com.demo.ManagerAppointmentSystem.controller;

import com.demo.ManagerAppointmentSystem.command.ManagerCommand;
import com.demo.ManagerAppointmentSystem.model.Manager;
import com.demo.ManagerAppointmentSystem.command.MeetingDetailsCommand;
import com.demo.ManagerAppointmentSystem.service.ManagerService;
import com.demo.ManagerAppointmentSystem.service.MeetingDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/managers")
//@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {


   @Autowired
   private ManagerService managerService;

    @GetMapping
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerService.getAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        Manager manager = managerService.getManagerById(id);
        if (manager != null) {
            return new ResponseEntity<>(manager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add-manager")
    public ResponseEntity<Manager> createManager(@RequestBody ManagerCommand managerCommand) {
        if(managerCommand == null)
            return null;


        Manager manager = new Manager();
        manager.setFirstName(managerCommand.getFirstName());
        manager.setLastName(managerCommand.getLastName());
        manager.setEmail(managerCommand.getEmail());
        manager.setPhoneNumber(managerCommand.getPhoneNumber());
        manager.setAddress(managerCommand.getAddress());
        manager.setGender(managerCommand.getGender());
        Manager createdManager = managerService.createManager(manager);
        return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }

    @PutMapping("/update-manager/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody ManagerCommand managerCommand) {
        // Check if the manager with the given id exists
        Manager existingManager = managerService.getManagerById(id);

        if (existingManager == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the existing manager with the data from ManagerCommand
        existingManager.setFirstName(managerCommand.getFirstName());
        existingManager.setLastName(managerCommand.getLastName());
        existingManager.setEmail(managerCommand.getEmail());
        existingManager.setPhoneNumber(managerCommand.getPhoneNumber());
        existingManager.setAddress(managerCommand.getAddress());
        existingManager.setGender(managerCommand.getGender());

        // Save the updated manager
        Manager updatedManager = managerService.updateManager(id, existingManager);

        // Return the updated manager in the response
        return new ResponseEntity<>(updatedManager, HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager manager) {
//        Manager updatedManager = managerService.updateManager(id, manager);
//        if (updatedManager != null) {
//            return new ResponseEntity<>(updatedManager, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete-manager/{managerId}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long managerId) {
        managerService.deleteManager(managerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
