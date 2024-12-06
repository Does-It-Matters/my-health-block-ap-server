package com.example.myhealthblock.doctor.application.port.in.dto;

public class DoctorSignUpInputPortResponseDTO implements DoctorSignUpInputPortResponse {
    private String id;
    private String name;
    private String field;
    private String hospital;
    private String introduction;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String getHospital() {
        return hospital;
    }

    @Override
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public String getIntroduction() {
        return introduction;
    }

    @Override
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}