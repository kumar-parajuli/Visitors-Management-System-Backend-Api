package com.demo.ManagerAppointmentSystem.repository;

import com.demo.ManagerAppointmentSystem.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
