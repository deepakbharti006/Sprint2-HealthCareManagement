package com.capgemini.hcm.controller;

import com.capgemini.hcm.exception.TestException;
import com.capgemini.hcm.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/approveAppointment/{testAppointmentId}")
    public ResponseEntity<String> approveappointment(@PathVariable Integer testAppointmentId) throws TestException {
        try {
            appointmentService.approveAppointment(testAppointmentId, true);
            return new ResponseEntity<>("Appointment approved", HttpStatus.OK);
        } catch (Exception exception) {
            throw new TestException(exception.getMessage());
        }
    }
}
