package com.capgemini.hcm.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hcm.dao.DiagnosticCenterDao;
import com.capgemini.hcm.dao.TestDao;
import com.capgemini.hcm.dao.TestDao1;
import com.capgemini.hcm.dto.TestDto;
import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.Test;
import com.capgemini.hcm.exception.TestException;

@Service
@Transactional
public class TestService {

	@Autowired
	TestDao testDao;
	@Autowired
	TestDao1 testDao1;
	@Autowired
	DiagnosticCenterDao diagnosticCenterDao;

	public boolean addCenter(DiagnosticCenter diagnosticCenter) throws TestException {
	
		if (diagnosticCenterDao.save(diagnosticCenter) != null)
			return true;
		else
			throw new TestException("Center not added.");
	}

	public String addTest(Integer centerId, Test test) throws TestException {
		if (testDao.addTest(centerId, test))
			return "Test Added Successfully";
		else
			throw new TestException("Test already exists");
	}

	public void removeTest(Integer testId) {
		testDao1.deleteById(testId);
		}

	public List<DiagnosticCenter> getAllCenter() throws TestException {
		if(diagnosticCenterDao.findAll() != null)
			return diagnosticCenterDao.findAll();
		else
			throw new TestException("Diagnostic Centers not present. ");
	}

	public Optional<DiagnosticCenter> getCenter(Integer centerId) throws TestException {
		if(diagnosticCenterDao.findById(centerId)!=null) {
			return diagnosticCenterDao.findById(centerId);
		}
		else {
			throw new TestException("Diagnostic Center not found.");
		}
	}

}
