package com.example.myhealthblock.doctor.application.port.out.dto;

import lombok.AllArgsConstructor;

/**
 * <b> 역할: 의료진 프로필 DTO </b>
 * <br>- 출력 어댑터 계층에서 도메인 계층으로 전달하는 데이터
 */
@AllArgsConstructor
public class DoctorProfileOutputPortResponseDTO implements DoctorProfileOutputPortResponse {
    private String name;
    private String field;
    private String hospital;
    private String introduction;

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
