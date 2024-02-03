//package com.demo.ManagerAppointmentSystem.service;
//
//
//
//import com.demo.ManagerAppointmentSystem.model.Appointment;
//
//import com.demo.ManagerAppointmentSystem.model.MeetingDetails;
//import com.demo.ManagerAppointmentSystem.repository.AppointmentReprository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AppointmentService {
//
//    @Autowired
//    private AppointmentReprository appointmentReprository;
//
//    public List<Appointment> getAllAppointments() {
//        return appointmentReprository.findAll();
//    }
//
//    public Appointment getAppointmentById(Long id) {
//        return appointmentReprository.findById(id).orElse(null);
//    }
//
//    public Appointment addAppointment(Appointment appointment) {
//        return appointmentReprository.save(appointment);
//    }
//
//    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
//        if (appointmentReprository.existsById(id)) {
//            updatedAppointment.setId(id);
//            return appointmentReprository.save(updatedAppointment);
//        }
//        return null;
//    }
//
//    public void deleteAppointment(Long id) {
//        appointmentReprository.deleteById(id);
//    }
//}