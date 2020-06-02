//package com.capgemini.hcm;
//
//import javax.persistence.EntityManager;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.capgemini.hcm.service.TestService;
//import com.capgemini.hcm.entity.Test;
//
//@SpringBootTest
//@DataJpaTest
//@ExtendWith(SpringExtension.class)
//@Import(TestService.class)
//class HealthCareManagementApplicationTests {
//	
//	@Autowired
//	private TestService testService;
//
//	@Autowired
//	private EntityManager em;
//	
//	/**
//	 * case when appointment does not exist in database before
//	 */
//	@Test
//	public void testSaveAppointment() {
//		String centerId = "1222", testId = "201", testName="Blood Sugar";
//		Test test=new 
//		Appointment appointment = new Appointment();
//		appointment.setCenterId(centerId);
//		appointment.setDateTime(dateTime);
//		appointment.setStatus(status);
//		appointment.setTestId(testId);
//		appointment.setUserId(userId);
//		String result = service.makeAppointment(userId, centerId, testId, dateTime);
//		List<Appointment> fetched = em.createQuery("FROM Appointment").getResultList();
//		Assertions.assertEquals(1, fetched.size());
//		Appointment app = fetched.get(0);
//		String expected = app.getAppointmentId().toString();
//		Assertions.assertEquals(expected, result);
//	}
//
//}
