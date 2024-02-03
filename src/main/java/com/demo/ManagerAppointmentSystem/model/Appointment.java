//package com.demo.ManagerAppointmentSystem.model;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//public class Appointment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "manager_id", referencedColumnName = "id")
//    private Manager manager;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "visitor_id", referencedColumnName = "id")
//    private Visitor visitor;
//
//    @Column(name = "manager_first_name")
//    private String managerFirstName;
//
//    @Column(name = "visitor_first_name")
//    private String visitorFirstName;
//
//    private LocalDate appointmentDate;
//    private String remarks;
//    private String selectTime;
//    private String appointmentTitle;
//    private String attendees;
//
//    public Appointment(){
//
//    }
//
//    public Appointment(Long id, Manager manager, Visitor visitor, String managerFirstName, String visitorFirstName, LocalDate appointmentDate, String remarks, String selectTime, String appointmentTitle, String attendees) {
//        this.id = id;
//        this.manager = manager;
//        this.visitor = visitor;
//        this.managerFirstName = managerFirstName;
//        this.visitorFirstName = visitorFirstName;
//        this.appointmentDate = appointmentDate;
//        this.remarks = remarks;
//        this.selectTime = selectTime;
//        this.appointmentTitle = appointmentTitle;
//        this.attendees = attendees;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Manager getManager() {
//        return manager;
//    }
//
//    public void setManager(Manager manager) {
//        this.manager = manager;
//    }
//
//    public Visitor getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(Visitor visitor) {
//        this.visitor = visitor;
//    }
//
//    public String getManagerFirstName() {
//        return managerFirstName;
//    }
//
//    public void setManagerFirstName(String managerFirstName) {
//        this.managerFirstName = managerFirstName;
//    }
//
//    public String getVisitorFirstName() {
//        return visitorFirstName;
//    }
//
//    public void setVisitorFirstName(String visitorFirstName) {
//        this.visitorFirstName = visitorFirstName;
//    }
//
//    public LocalDate getAppointmentDate() {
//        return appointmentDate;
//    }
//
//    public void setAppointmentDate(LocalDate appointmentDate) {
//        this.appointmentDate = appointmentDate;
//    }
//
//    public String getRemarks() {
//        return remarks;
//    }
//
//    public void setRemarks(String remarks) {
//        this.remarks = remarks;
//    }
//
//    public String getSelectTime() {
//        return selectTime;
//    }
//
//    public void setSelectTime(String selectTime) {
//        this.selectTime = selectTime;
//    }
//
//    public String getAppointmentTitle() {
//        return appointmentTitle;
//    }
//
//    public void setAppointmentTitle(String appointmentTitle) {
//        this.appointmentTitle = appointmentTitle;
//    }
//
//    public String getAttendees() {
//        return attendees;
//    }
//
//    public void setAttendees(String attendees) {
//        this.attendees = attendees;
//    }
//}