//package com.demo.ManagerAppointmentSystem.controller;
//
//import com.demo.ManagerAppointmentSystem.command.AppointmentCommand;
//import com.demo.ManagerAppointmentSystem.model.Appointment;
//import com.demo.ManagerAppointmentSystem.model.Manager;
//import com.demo.ManagerAppointmentSystem.model.Visitor;
//import com.demo.ManagerAppointmentSystem.service.AppointmentService;
//
//import com.demo.ManagerAppointmentSystem.service.ManagerService;
//import com.demo.ManagerAppointmentSystem.service.VisitorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/appointments")
//public class AppointmentController {
//
//private final AppointmentService appointmentService;
//    @Autowired
//    private VisitorService visitorService;
//    @Autowired
//    private ManagerService managerService;
//@Autowired
//public AppointmentController(AppointmentService appointmentService) {
//    this.appointmentService = appointmentService;
//}
//
//@GetMapping()
//public ResponseEntity<List<Appointment>> getAllAppointments() {
//    List<Appointment> appointments = appointmentService.getAllAppointments();
//    return new ResponseEntity<>(appointments, HttpStatus.OK);
//}
//
//@GetMapping("/{id}")
//public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
//    Appointment appointment = appointmentService.getAppointmentById(id);
//    if (appointment != null) {
//        return new ResponseEntity<>(appointment, HttpStatus.OK);
//    } else {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//}
//
//@PostMapping("/add-appointment")
//public ResponseEntity<Appointment> addAppointment(@RequestBody AppointmentCommand appointmentCommand) {
//    if (appointmentCommand == null) {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    Visitor visitor = visitorService.getVisitorById(appointmentCommand.getVisitorId());
//    Manager manager = managerService.getManagerById(appointmentCommand.getManagerId());
//
////    Visitor visitor = visitorService.getVisitorByFirstname(appointmentCommand.getVisitorFirstname());
////    Manager manager = managerService.getManagerByFirstname(appointmentCommand.getManagerFirstname());
//
//    if (visitor == null || manager == null) {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Visitor or Manager not found
//    }
//
//    Appointment appointment = new Appointment();
//    appointment.setVisitor(visitor);
//    appointment.setManager(manager);
//    appointment.setManagerFirstName(appointmentCommand.getManagerFirstname());
//    appointment.setVisitorFirstName(appointmentCommand.getVisitorFirstname());
//    appointment.setRemarks(appointmentCommand.getRemarks());
//
//    appointment.setAppointmentDate(appointmentCommand.getAppointmentDate());
//appointment.setVisitorFirstName(visitor.getFirstName());
//appointment.setManagerFirstName(manager.getFirstName());
//    Appointment addedAppointment = appointmentService.addAppointment(appointment);
//    return new ResponseEntity<>(addedAppointment, HttpStatus.CREATED);
//}
//
//@PutMapping("/{id}")
//public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody AppointmentCommand appointmentCommand) {
//    Appointment existingAppointment = appointmentService.getAppointmentById(id);
//    if (existingAppointment != null) {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    Appointment updatedAppointment = new Appointment();
//    updatedAppointment.setId(id);
//    updatedAppointment.setVisitor(visitorService.getVisitorById(appointmentCommand.getVisitorId()));
//    updatedAppointment.setManager(managerService.getManagerById(appointmentCommand.getManagerId()));
//    updatedAppointment.setRemarks(appointmentCommand.getRemarks());
//updatedAppointment.setAppointmentDate(appointmentCommand.getAppointmentDate());
//    updatedAppointment = appointmentService.updateAppointment(id, updatedAppointment);
//if(updatedAppointment != null){
//    return new ResponseEntity<>(updatedAppointment,HttpStatus.OK);
//
//} else {
//    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//}
//}
//
//@DeleteMapping("/{id}")
//public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
//    appointmentService.deleteAppointment(id);
//    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//}
//}
