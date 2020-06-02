package com.capgemini.hcm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.Test;
import com.capgemini.hcm.exception.TestException;
import com.capgemini.hcm.service.TestService;

/************************************************************************************
 *  
 *         Description 		Test controller class which provides functionality of
 *         					adding a test, removing a test, viewing diagnostic centers and
 *        					handles the corresponding exceptions.
 * 
 *         Created Date 	15-MAY-2020
 *         
 *         @author          Deepak Bharti
 ************************************************************************************/
@CrossOrigin
@RestController
public class TestController {

	@Autowired
	TestService testService;

	/************************************************************************************
	 * Method: addTest
     *Description: 			To add a test under a particular diagnostic center.
	 * @param centerId       - center's id
	 * @param test			 - test Object
	 * @returns String       - Test Added successfully
	 * @throws TestException - It is raised if test already exists.
	 * 
	 * @author Deepak Bharti
	 ************************************************************************************/
	@PostMapping("/addTest/{centerId}")
	public ResponseEntity<String> addTest(@PathVariable Integer centerId, @RequestBody Test test) throws TestException {
		
		try {
			testService.addTest(centerId, test);
			return new ResponseEntity<String>("Test added in center successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new TestException(ex.getMessage());
		}
	}
	
	/************************************************************************************
	 * Method: addCenter
     *Description: 			To add a diagnostic center.
	 * @param centerId       - center's id
	 * @returns String       - Test Added successfully.
	 * @throws TestException - It is raised if test already exists.
	 * 
	 * @author Deepak Bharti
	 ************************************************************************************/
	@PostMapping("/addcenter")
	public ResponseEntity<String> addCenter(@RequestBody DiagnosticCenter diagnosticcenter)
			throws TestException {
		try {
			testService.addcenter(diagnosticcenter);
			return new ResponseEntity<String>("Center added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new TestException("ID already exists");
		}
	}

	/************************************************************************************
	 * Method: removeTest
     *Description: 			To remove a particular test under a diagnostic center
	 * @param testId         - test id
	 * @returns String       - Test deleted successfully.
	 * @throws TestException - Test already exists.
	 * 
	 * @author Deepak Bharti
	 ************************************************************************************/
	@DeleteMapping(value = "/removeTest/{testId}")
	public ResponseEntity<String> removeTest(@PathVariable Integer testId) throws TestException {
		try {
			testService.removeTest(testId);
			return new ResponseEntity<>("Test deleted successfully", HttpStatus.OK);
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}
	}

	/************************************************************************************
	 * Method: getAllCenter
     *Description: To get all diagnostic center available.
	 * @returns List		 - Type Diagnostic Center.
	 * @throws TestException - Diagnostic Centers not present.
	 * 
	 * @author Deepak Bharti
	 ************************************************************************************/
	@GetMapping("/centers")
	public ResponseEntity<List<DiagnosticCenter>> getAllCenter() throws TestException {
		try {
			List<DiagnosticCenter> diagnosticCenterList = testService.getAllCenter();
			return new ResponseEntity<List<DiagnosticCenter>>(diagnosticCenterList, HttpStatus.OK);
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}
	}

	/************************************************************************************
	 * Method: getCenter
     *Description: To get a particular diagnostic center available along with its tests.
	 * @returns Object		 - Type Diagnostic Center.
	 * @throws TestException - Diagnostic Center not found.
	 * 
	 * @author Deepak Bharti
	 ************************************************************************************/
	@GetMapping("/center/{centerId}")
	public Optional<DiagnosticCenter> getCenter(@PathVariable Integer centerId) throws TestException {
		try {
			return testService.getCenter(centerId);
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}
	}

}
