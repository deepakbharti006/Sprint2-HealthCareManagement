package com.capgemini.hcm.controller;

import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.TestAppointment;
import com.capgemini.hcm.entity.Users;
import com.capgemini.hcm.exception.TestException;
import com.capgemini.hcm.service.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TestControllerTest {

	private TestController testControllerUnderTest;

	@BeforeEach
	void setUp() {
		testControllerUnderTest = new TestController();
		testControllerUnderTest.testService = mock(TestService.class);
	}

	@Test
	void testRemoveTest() throws Exception {
		// Setup
		final ResponseEntity<String> expectedResult = new ResponseEntity<>("Test deleted successfully",
				HttpStatus.CONTINUE);

		// Run the test
		final ResponseEntity<String> result = testControllerUnderTest.removeTest(0);

		// Verify the results
		assertEquals(expectedResult.getBody(), result.getBody());
		verify(testControllerUnderTest.testService).removeTest(0);
	}

	@Test
	void testGetAllCenter() throws Exception {
		// Setup

		// Configure TestService.getAllCenter(...).
		final List<DiagnosticCenter> diagnosticCenters = Collections.singletonList(new DiagnosticCenter(0,
				"Lal Path labs", Collections.singletonList(new com.capgemini.hcm.entity.Test(0, "Blood test")),
				Collections.singletonList(new TestAppointment(0, LocalDateTime.of(2020, 1, 1, 0, 0, 0), false,
						new Users(0, "Deepak@123", "Deepak", new BigInteger("100"), "customer", "Deepak@gmail.com")))));
		when(testControllerUnderTest.testService.getAllCenter()).thenReturn(diagnosticCenters);

		// Run the test
		final ResponseEntity<List<DiagnosticCenter>> result = testControllerUnderTest.getAllCenter();

	}

	@Test
	void testGetAllCenter_TestServiceThrowsTestException() throws Exception {
		// Setup
		when(testControllerUnderTest.testService.getAllCenter()).thenThrow(TestException.class);

		// Run the test
		assertThrows(TestException.class, () -> testControllerUnderTest.getAllCenter());
	}

	@Test
	void testGetCenter() throws Exception {
		// Setup

		// Configure TestService.getCenter(...).
		final Optional<DiagnosticCenter> diagnosticCenter = Optional.of(new DiagnosticCenter(0, "Lal Path labs",
				Collections.singletonList(new com.capgemini.hcm.entity.Test(0, "Blood test")),
				Collections.singletonList(new TestAppointment(0, LocalDateTime.of(2020, 1, 1, 0, 0, 0), false,
						new Users(0, "Deepak@123", "Deepak", new BigInteger("100"), "customer", "Deepak@gmail.com")))));
		when(testControllerUnderTest.testService.getCenter(0)).thenReturn(diagnosticCenter);

		// Run the test
		final Optional<DiagnosticCenter> result = testControllerUnderTest.getCenter(0);

	}

	@Test
	void testGetCenter_TestServiceThrowsTestException() throws Exception {
		// Setup
		when(testControllerUnderTest.testService.getCenter(0)).thenThrow(TestException.class);

		// Run the test
		assertThrows(TestException.class, () -> testControllerUnderTest.getCenter(0));
	}
}
