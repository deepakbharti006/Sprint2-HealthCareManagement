package com.capgemini.hcm.controller;

import com.capgemini.hcm.exception.TestException;
import com.capgemini.hcm.service.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AppointmentControllerTest {

    private AppointmentController appointmentControllerUnderTest;

    @BeforeEach
    void setUp() {
        appointmentControllerUnderTest = new AppointmentController();
        appointmentControllerUnderTest.appointmentService = mock(AppointmentService.class);
    }

    @Test
    void testApproveappointment() throws Exception {
        // Setup
        final ResponseEntity<String> expectedResult = new ResponseEntity<>("Appointment approved", HttpStatus.CONTINUE);

        // Run the test
        final ResponseEntity<String> result = appointmentControllerUnderTest.approveappointment(0);

        // Verify the results
        assertEquals(expectedResult.getBody(), result.getBody());
        verify(appointmentControllerUnderTest.appointmentService).approveAppointment(0, true);
    }

    @Test
    void testApproveappointment_AppointmentServiceThrowsTestException() throws Exception {
        // Setup
        doThrow(TestException.class).when(appointmentControllerUnderTest.appointmentService).approveAppointment(null, true);

        // Run the test
        assertThrows(TestException.class, () -> appointmentControllerUnderTest.approveappointment(null));
    }
}
