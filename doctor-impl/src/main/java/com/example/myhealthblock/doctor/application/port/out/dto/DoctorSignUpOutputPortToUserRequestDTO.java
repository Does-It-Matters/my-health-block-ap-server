package com.example.myhealthblock.doctor.application.port.out.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: 의료진 출력 포트 DTO 클래스 </b>
 * <br>- 사용자 회원 가입 시 필요한 정보
 */
@Getter
@Setter
public class DoctorSignUpOutputPortToUserRequestDTO implements DoctorSignUpOutputPortToUserRequest {
    private String id;
    private String pw;
    private String role;
}
