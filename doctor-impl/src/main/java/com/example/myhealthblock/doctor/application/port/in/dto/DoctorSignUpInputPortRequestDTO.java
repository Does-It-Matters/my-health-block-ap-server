package com.example.myhealthblock.doctor.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DoctorSignUpInputPortRequestDTO implements DoctorSignUpInputPortRequest {
    private String id;
    private String pw;
    private String role;
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
    public String getPw() {
        return pw;
    }

    @Override
    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
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