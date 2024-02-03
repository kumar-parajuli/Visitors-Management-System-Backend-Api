package com.demo.ManagerAppointmentSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MeetingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "visitor_id", referencedColumnName = "id")
    private Visitor visitor;



private String bookingAppointment;
    private LocalDate appointmentDate;
    private String remarks;

    // Constructors, Getters, and Setters


    public MeetingDetails() {

    }

    public MeetingDetails(Long id, Manager manager, Visitor visitor, String bookingAppointment, LocalDate appointmentDate, String remarks) {
        this.id = id;
        this.manager = manager;
        this.visitor = visitor;
        this.bookingAppointment = bookingAppointment;
        this.appointmentDate = appointmentDate;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getBookingAppointment() {
        return bookingAppointment;
    }

    public void setBookingAppointment(String bookingAppointment) {
        this.bookingAppointment = bookingAppointment;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
