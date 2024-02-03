package com.demo.ManagerAppointmentSystem.service;

import com.demo.ManagerAppointmentSystem.model.MeetingDetails;
import com.demo.ManagerAppointmentSystem.repository.MeetingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingDetailsServices {
    @Autowired
    private MeetingDetailsRepository meetingDetailsRepository;

    public List<MeetingDetails> getAllMeetingDetails() {
        return meetingDetailsRepository.findAll();
    }

    public MeetingDetails getMeetingDetailsById(Long id) {
        return meetingDetailsRepository.findById(id).orElse(null);
    }

    public MeetingDetails addMeetingDetails(MeetingDetails meetingDetails) {
        return meetingDetailsRepository.save(meetingDetails);
    }

    public MeetingDetails updateMeetingDetails(Long id, MeetingDetails meetingDetails) {
        if (meetingDetailsRepository.existsById(id)) {
            meetingDetails.setId(id);
            return meetingDetailsRepository.save(meetingDetails);
        }
        return null;
    }

    public void deleteMeetingDetails(Long id) {
        meetingDetailsRepository.deleteById(id);
    }
}
