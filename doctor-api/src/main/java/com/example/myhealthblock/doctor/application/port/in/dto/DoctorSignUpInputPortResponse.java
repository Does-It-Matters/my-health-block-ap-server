package com.example.myhealthblock.doctor.application.port.in.dto;

public interface DoctorSignUpInputPortResponse {
    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getField();

    void setField(String field);

    String getHospital();

    void setHospital(String hospital);

    String getIntroduction();

    void setIntroduction(String introduction);
}
