package com.example.myhealthblock.patient.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 컨트롤러 계층에서 서비스 계층으로 데이터를 전달하는 DTO 클래스 </b>
 * <br>- 환자 회원 가입 시 필요한 정보
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientSignUpInputPortRequestDTO  implements PatientSignUpInputPortRequest {
    String id;
    String pw;
    String role;
}
