package com.capgemini.hcm.service;

import com.capgemini.hcm.dao.DiagnosticCenterDao;
import com.capgemini.hcm.dao.TestDao;
import com.capgemini.hcm.dao.TestDao1;
import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.Test;
import com.capgemini.hcm.exception.TestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

/************************************************************************************
 *  
 *         Description 		Test service class which provides functionality of
 *         					adding a test, removing a test, viewing diagnostic centers and
 *        					handles the corresponding exceptions.
 * 
 *         Created Date 	14-MAY-2020
 *         
 *         @author          Deepak Bharti
 ************************************************************************************/
@Transactional
@Service
public class TestService {

    @Autowired
    TestDao testDao;
    @Autowired
    TestDao1 testDao1;
    @Autowired
    DiagnosticCenterDao diagnosticCenterDao;


    public String addTest(Integer centerId, Test test) throws TestException {
    	if (Objects.isNull(centerId)) {
    		throw new TestException("Center id is null!");
		}
        if (testDao.addTest(centerId, test))
            return "Test Added Successfully";
        else
            throw new TestException("Test already exists");
    }

    public void removeTest(Integer testId) {
        testDao1.deleteById(testId);
    }

    public List<DiagnosticCenter> getAllCenter() throws TestException {
        if (diagnosticCenterDao.findAll() != null)
            return diagnosticCenterDao.findAll();
        else
            throw new TestException("Diagnostic Centers not present. ");
    }

    public Optional<DiagnosticCenter> getCenter(Integer centerId) throws TestException {
    	if (Objects.isNull(centerId))
    		throw new TestException("center id cannot be null");
        if (diagnosticCenterDao.findById(centerId) != null) {
            return diagnosticCenterDao.findById(centerId);
        } else {
            throw new TestException("Diagnostic Center not found.");
        }
    }
    
    public boolean addcenter(DiagnosticCenter diagnosticcenter)
	{
		return diagnosticCenterDao.save(diagnosticcenter) != null;
	}

}
