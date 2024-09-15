package com.example.myhealthblock.user.application.port.in.dto;

public interface UserSignUpInputPortRequest {
    String getId();

    String getPw();

    String getRole();

    void setId(String id);

    void setPw(String pw);

    void setRole(String role);
}
