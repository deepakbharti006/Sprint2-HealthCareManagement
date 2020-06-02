package com.capgemini.hcm.service;

import com.capgemini.hcm.dao.AppointmentDao;
import com.capgemini.hcm.entity.TestAppointment;
import com.capgemini.hcm.entity.Users;
import com.capgemini.hcm.exception.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AppointmentServiceTest {

    private AppointmentService appointmentServiceUnderTest;

    @BeforeEach
    void setUp() {
        appointmentServiceUnderTest = new AppointmentService();
        appointmentServiceUnderTest.appointmentDao = mock(AppointmentDao.class);
    }

    @Test
    void testApproveAppointment() throws Exception {
        // Setup

        // Configure AppointmentDao.findById(...).
        final Optional<TestAppointment> testAppointment = Optional.of(new TestAppointment(0, LocalDateTime.of(2020, 1, 1, 0, 0, 0), false, new Users(0, "Deepak@123", "Deepak", new BigInteger("100"), "customer", "deepak@gmail.com")));
        when(appointmentServiceUnderTest.appointmentDao.findById(0)).thenReturn(testAppointment);

        when(appointmentServiceUnderTest.appointmentDao.updateStatus(false, 0)).thenReturn(0);

        // Run the test
        appointmentServiceUnderTest.approveAppointment(0, false);

    }

    @Test
    void testApproveAppointment_ThrowsTestException() {
        // Setup

        // Configure AppointmentDao.findById(...).
        final Optional<TestAppointment> testAppointment = Optional.of(new TestAppointment(0, LocalDateTime.of(2020, 1, 1, 0, 0, 0), false, new Users(0, "Deepak@123", "Deepak", new BigInteger("100"), "customer", "deepak@gmail.com")));
        when(appointmentServiceUnderTest.appointmentDao.findById(0)).thenReturn(testAppointment);

        when(appointmentServiceUnderTest.appointmentDao.updateStatus(false, 0)).thenReturn(0);

        // Run the test
        assertThrows(TestException.class, () -> appointmentServiceUnderTest.approveAppointment(null, false));
    }
}
