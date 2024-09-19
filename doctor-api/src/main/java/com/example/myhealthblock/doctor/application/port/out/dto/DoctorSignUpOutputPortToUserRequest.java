package com.example.myhealthblock.doctor.application.port.out.dto;

public interface DoctorSignUpOutputPortToUserRequest {
    String getId();

    String getPw();

    String getRole();

    void setId(String id);

    void setPw(String pw);

    void setRole(String role);
}
