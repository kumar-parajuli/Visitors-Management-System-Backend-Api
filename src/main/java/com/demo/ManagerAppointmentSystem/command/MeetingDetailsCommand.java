package com.demo.ManagerAppointmentSystem.command;

import java.time.LocalDate;

public class MeetingDetailsCommand {
    private Long managerId;
    private Long visitorId;
    private String remarks;
    private LocalDate appointmentDate;
    private String bookingAppointment;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getBookingAppointment() {
        return bookingAppointment;
    }

    public void setBookingAppointment(String bookingAppointment) {
        this.bookingAppointment = bookingAppointment;
    }
}
