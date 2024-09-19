package com.example.myhealthblock.user.application.port.in.dto;

public interface UserSignInInputPortRequest {
    String getId();

    String getPw();

    void setId(String id);

    void setPw(String pw);
}
