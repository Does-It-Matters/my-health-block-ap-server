package com.example.myhealthblock.patient.application.port.out.dto;

public interface PatientSignUpOutputPortToUserRequest {
	String getId();

	String getPw();

	String getRole();

	void setId(String id);

	void setPw(String pw);

	void setRole(String role);
}
