package com.capgemini.hcm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capgemini.hcm.entity.DiagnosticCenter;
import com.capgemini.hcm.entity.Test;

@Repository
public class TestDao {

	@PersistenceContext
	EntityManager em;

	public boolean addTest(Integer centerId, Test test) {
		DiagnosticCenter diagnosticCenter = em.find(DiagnosticCenter.class, centerId);
		String testName = test.getTestName();
		List<Test> testList = diagnosticCenter.getTest();

		for (Test t : testList) {
			if (t.getTestName().equalsIgnoreCase(testName)) {
				return false;
			}
		}
		test.setTestName(testName);
		diagnosticCenter.getTest().add(test);
		em.persist(diagnosticCenter);
		return true;

	}

}
