package com.capgemini.hcm.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Test_Appointment_Details")
public class TestAppointment {
	@Id
	@Column(name = "test_appointment_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@SequenceGenerator(sequenceName = "appointment_seq", initialValue = 1000, allocationSize = 1, name = "appointment_seq")
	private Integer testAppointmentId;

	@Column(name = "test_Appointment_DateAndTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime testAppointmentDate;

	@Column(name = "test_approved")
	private boolean approved;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	private Users users;

	public Integer getTestAppointmentId() {
		return testAppointmentId;
	}

	public void setTestAppointmentId(Integer testAppointmentId) {
		this.testAppointmentId = testAppointmentId;
	}

	public LocalDateTime getTestAppointmentDate() {
		return testAppointmentDate;
	}

	public void setTestAppointmentDate(LocalDateTime testAppointmentDate) {
		this.testAppointmentDate = testAppointmentDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean getApproved() {
		return this.approved;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public TestAppointment(Integer testAppointmentId, LocalDateTime testAppointmentDate, boolean approved,
			Users users) {
		super();
		this.testAppointmentId = testAppointmentId;
		this.testAppointmentDate = testAppointmentDate;
		this.approved = approved;
		this.users = users;
	}

	public TestAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TestAppointment [testAppointmentId=" + testAppointmentId + ", testAppointmentDate="
				+ testAppointmentDate + ", approved=" + approved + ", users=" + users + "]";
	}

	
}

