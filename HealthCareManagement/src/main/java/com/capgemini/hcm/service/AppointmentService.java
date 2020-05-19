package com.capgemini.hcm.service;

import javax.transaction.Transactional;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.AppointmentDao;
import com.capgemini.hcm.entity.TestAppointment;
import com.capgemini.hcm.exception.TestException;

@Transactional
@Service
public class AppointmentService {

	@Autowired
	AppointmentDao appointmentDao;

	@SuppressWarnings("null")
	public void approveAppointment(Integer testAppointmentId, boolean approved) throws TestException {

		Optional<TestAppointment> optionalTest = appointmentDao.findById(testAppointmentId);
		if (optionalTest.isPresent()) {
			try {

				appointmentDao.updateStatus(approved, testAppointmentId);
			} catch (DataIntegrityViolationException exception) {
				throw new TestException(exception.getMessage());
			}
		}

	}
}
