package com.demo.ManagerAppointmentSystem.repository;

import com.demo.ManagerAppointmentSystem.model.MeetingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingDetailsRepository extends JpaRepository<MeetingDetails,Long> {
}
