package com.example.myhealthblock.doctor.application.port.out.dto;

import lombok.AllArgsConstructor;

/**
 * <b> 역할: 의료진 프로필 DTO </b>
 * <br>- 출력 어댑터 계층에서 도메인 계층으로 전달하는 데이터
 */
@AllArgsConstructor
public class DoctorProfileOutputPortResponse {
    private String name;
    private String field;
    private String hospital;
    private String introduction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
