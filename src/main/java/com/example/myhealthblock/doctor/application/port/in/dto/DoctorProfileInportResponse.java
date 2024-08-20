package com.example.myhealthblock.doctor.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: 의료진 프로필 DTO </b>
 * <br>- 도메인 계층에서 입력 어댑터로 응답하는 객체
 */
@Getter
@Setter
@AllArgsConstructor
public class DoctorProfileInportResponse {
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}
