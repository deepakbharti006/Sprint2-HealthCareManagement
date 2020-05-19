package com.capgemini.hcm.dto;

import com.capgemini.hcm.entity.DiagnosticCenter;

public class TestDto {

	private DiagnosticCenter diagnosticCenter;

	public DiagnosticCenter getCenter() {
		return diagnosticCenter;
	}

	public void setCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	@Override
	public String toString() {
		return "TestDto [center=" + diagnosticCenter + "]";
	}

	public TestDto(DiagnosticCenter diagnosticCenter) {

		this.diagnosticCenter = diagnosticCenter;
	}

	public TestDto() {

	}

}

