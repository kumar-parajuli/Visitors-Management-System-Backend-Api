package com.demo.ManagerAppointmentSystem.repository;

import com.demo.ManagerAppointmentSystem.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository <Visitor, Long>{


}
