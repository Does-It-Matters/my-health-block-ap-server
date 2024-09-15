package com.example.myhealthblock.user.application.port.in.dto;

public interface UserSignInInputPortResponse {
    String getRole();

    String getId();

    void setRole(String role);

    void setId(String id);
}
