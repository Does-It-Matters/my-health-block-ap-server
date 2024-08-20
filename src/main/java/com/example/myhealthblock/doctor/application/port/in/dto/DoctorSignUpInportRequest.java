package com.example.myhealthblock.doctor.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 컨트롤러 계층에서 서비스 계층으로 데이터를 전달하는 DTO 클래스 </b>
 * <br>- 의료진 회원가입 시 필요한 정보
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSignUpInportRequest {
    private String id;
    private String pw;
    private String role;
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}