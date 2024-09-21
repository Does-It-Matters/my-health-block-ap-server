package com.example.myhealthblock.doctor.application.port.in.dto;

public interface DoctorSignUpInputPortRequest {
    String getId();

    void setId(String id);

    String getPw();

    void setPw(String pw);

    String getRole();

    void setRole(String role);

    String getName();

    void setName(String name);

    String getField();

    void setField(String field);

    String getHospital();

    void setHospital(String hospital);

    String getIntroduction();

    void setIntroduction(String introduction);
}
