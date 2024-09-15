package com.example.myhealthblock.user.application.port.in.dto;

public interface UserUpdatePwInputPortRequest {
    String getOldPw();

    String getNewPw();

    void setOldPw(String oldPw);

    void setNewPw(String newPw);
}
