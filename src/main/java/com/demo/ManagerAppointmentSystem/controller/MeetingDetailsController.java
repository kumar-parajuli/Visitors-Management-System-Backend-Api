package com.demo.ManagerAppointmentSystem.controller;


import com.demo.ManagerAppointmentSystem.command.MeetingDetailsCommand;
import com.demo.ManagerAppointmentSystem.model.MeetingDetails;
import com.demo.ManagerAppointmentSystem.model.Visitor;
import com.demo.ManagerAppointmentSystem.model.Manager;
import com.demo.ManagerAppointmentSystem.service.ManagerService;
import com.demo.ManagerAppointmentSystem.service.MeetingDetailsServices;
import com.demo.ManagerAppointmentSystem.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/meeting-details")
public class MeetingDetailsController {

    @Autowired
    private MeetingDetailsServices meetingDetailsServices;
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private ManagerService managerService;


    //Get all meetingDetails
    @GetMapping
    public ResponseEntity<List<MeetingDetails>> getAllMeetingDetails() {
        List<MeetingDetails> meetingDetailsList = meetingDetailsServices.getAllMeetingDetails();
        return new ResponseEntity<>(meetingDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingDetails> getMeetingDetailsById(@PathVariable Long id) {
        MeetingDetails meetingDetails = meetingDetailsServices.getMeetingDetailsById(id);
        if (meetingDetails != null) {
            return new ResponseEntity<>(meetingDetails, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<MeetingDetails> addMeetingDetails(@RequestBody MeetingDetailsCommand meetingDetailsCommand) {
        if(meetingDetailsCommand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Visitor visitor = visitorService.getVisitorById(meetingDetailsCommand.getVisitorId());
        Manager manager = managerService.getManagerById(meetingDetailsCommand.getManagerId());

        if (visitor == null || manager == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Visitor or Manager not found
        }
        MeetingDetails meetingDetails = new MeetingDetails();
        meetingDetails.setVisitor(visitor);
        meetingDetails.setManager(manager);
        meetingDetails.setRemarks(meetingDetailsCommand.getRemarks());
        meetingDetails.setAppointmentDate(meetingDetailsCommand.getAppointmentDate());
        meetingDetails.setBookingAppointment(meetingDetailsCommand.getBookingAppointment());
        MeetingDetails addedMeetingDetails = meetingDetailsServices.addMeetingDetails(meetingDetails);
        return new ResponseEntity<>(addedMeetingDetails, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MeetingDetails> updateMeetingDetails(@PathVariable Long id, @RequestBody MeetingDetails meetingDetails) {
        MeetingDetails updateMeetingDetails = meetingDetailsServices.updateMeetingDetails(id, meetingDetails);
        if (updateMeetingDetails != null) {
            return new ResponseEntity<>(updateMeetingDetails, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/delete-meeting/{id}")
    public ResponseEntity<Void> deleteMeetingDetails(@PathVariable Long id) {
        meetingDetailsServices.deleteMeetingDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



