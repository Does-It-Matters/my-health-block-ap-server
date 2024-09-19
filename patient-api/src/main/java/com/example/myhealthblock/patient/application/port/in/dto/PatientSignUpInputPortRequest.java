package com.example.myhealthblock.patient.application.port.in.dto;

public interface PatientSignUpInputPortRequest {
	String getId();

	String getPw();

	String getRole();

	void setId(String id);

	void setPw(String pw);

	void setRole(String role);
}