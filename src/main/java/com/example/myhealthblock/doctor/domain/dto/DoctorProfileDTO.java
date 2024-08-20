package com.example.myhealthblock.doctor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: 의료진 프로필 DTO </b>
 * <br>- 의료진 프로필 정보
 */
@Getter
@Setter
@AllArgsConstructor
public class DoctorProfileDTO {
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}
