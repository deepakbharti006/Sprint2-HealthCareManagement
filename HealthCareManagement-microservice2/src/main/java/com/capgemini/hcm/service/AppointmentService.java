package com.capgemini.hcm.service;

import com.capgemini.hcm.dao.AppointmentDao;
import com.capgemini.hcm.entity.TestAppointment;
import com.capgemini.hcm.exception.TestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class AppointmentService {

    @Autowired
    AppointmentDao appointmentDao;

    @SuppressWarnings("null")
    public void approveAppointment(Integer testAppointmentId, boolean approved) throws TestException {
        if (Objects.isNull(testAppointmentId))
            throw new TestException("No such appointment id");
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
