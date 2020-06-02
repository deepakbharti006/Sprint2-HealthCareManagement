package com.capgemini.hcm.service;

import com.capgemini.hcm.dao.DiagnosticCenterDao;
import com.capgemini.hcm.dao.TestDao;
import com.capgemini.hcm.dao.TestDao1;
import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.TestAppointment;
import com.capgemini.hcm.entity.Users;
import com.capgemini.hcm.exception.TestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestServiceTest {

    private TestService testServiceUnderTest;

    @BeforeEach
    void setUp() {
        testServiceUnderTest = new TestService();
        testServiceUnderTest.testDao = mock(TestDao.class);
        testServiceUnderTest.testDao1 = mock(TestDao1.class);
        testServiceUnderTest.diagnosticCenterDao = mock(DiagnosticCenterDao.class);
    }

    @Test
    void testAddTest()  {
        // Setup
        final com.capgemini.hcm.entity.Test test = new com.capgemini.hcm.entity.Test(0, "blood test");
        when(testServiceUnderTest.testDao.addTest(0, new com.capgemini.hcm.entity.Test(0, "blood test"))).thenReturn(false);

        // Run the test
        try {
            final String result = testServiceUnderTest.addTest(0, test);
            // Verify the results
            assertEquals("result", result);
        }
        catch (Exception h) {
            if (!h.getMessage().trim().equals("Test already exists"))
                fail();
        }
    }

    @Test
    void testAddTest_ThrowsTestException() {
        // Setup
        final com.capgemini.hcm.entity.Test test = new com.capgemini.hcm.entity.Test(0, "blood test");
        when(testServiceUnderTest.testDao.addTest(0, new com.capgemini.hcm.entity.Test(0, "blood test"))).thenReturn(false);

        // Run the test
        assertThrows(TestException.class, () -> testServiceUnderTest.addTest(0, test));
    }

    @Test
    void testRemoveTest() {
        // Setup

        // Run the test
        testServiceUnderTest.removeTest(0);

        // Verify the results
        verify(testServiceUnderTest.testDao1).deleteById(0);
    }

    @Test
    void testGetAllCenter() throws Exception {
        // Setup

        // Configure DiagnosticCenterDao.findAll(...).
        final List<DiagnosticCenter> diagnosticCenters = Collections.singletonList(new DiagnosticCenter(0, "Lal Path Labs", Collections.singletonList(new com.capgemini.hcm.entity.Test(0, "blood test")), Collections.singletonList(new TestAppointment(0, LocalDateTime.of(2020, 1, 1, 0, 0, 0), false, new Users(0, "Deepak@123", "Deepak", new BigInteger("100"), "customer", "deepak@gmail.com")))));
        when(testServiceUnderTest.diagnosticCenterDao.findAll()).thenReturn(diagnosticCenters);

        // Run the test
        final List<DiagnosticCenter> result = testServiceUnderTest.getAllCenter();

        // Verify the results
    }

    @Test
    void testGetCenter() throws Exception {
        // Setup

        // Configure DiagnosticCenterDao.findById(...).
        final Optional<DiagnosticCenter> diagnosticCenter = Optional.of(new DiagnosticCenter(0, "Lal Path Labs", Collections.singletonList(new com.capgemini.hcm.entity.Test(0, "blood test")), Collections.singletonList(new TestAppointment(0, LocalDateTime.of(2020, 1, 1, 0, 0, 0), false, new Users(0, "Deepak@123", "Deepak", new BigInteger("100"), "customer", "deepak@gmail.com")))));
        when(testServiceUnderTest.diagnosticCenterDao.findById(0)).thenReturn(diagnosticCenter);

        // Run the test
        final Optional<DiagnosticCenter> result = testServiceUnderTest.getCenter(0);

        // Verify the results
    }

    @Test
    void testGetCenter_ThrowsTestException() {
        // Setup

        // Configure DiagnosticCenterDao.findById(...).
        final Optional<DiagnosticCenter> diagnosticCenter = Optional.of(new DiagnosticCenter(0, "Lal Path Labs", Collections.singletonList(new com.capgemini.hcm.entity.Test(0, "blood test")), Collections.singletonList(new TestAppointment(0, LocalDateTime.of(2020, 1, 1, 0, 0, 0), false, new Users(0, "Deepak@123", "Deepak", new BigInteger("100"), "customer", "deepak@gmail.com")))));
        when(testServiceUnderTest.diagnosticCenterDao.findById(0)).thenReturn(diagnosticCenter);

        // Run the test
        assertThrows(TestException.class, () -> testServiceUnderTest.getCenter(null));
    }
}
