package com.example.myhealthblock.patient.application.port.out.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 환자 출력 포트 DTO 클래스 </b>
 * <br>- 사용자 회원 가입 시 필요한 정보
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientSignUpOutputPortToUserRequest {
    private String id;
    private String pw;
    private String role;
}
