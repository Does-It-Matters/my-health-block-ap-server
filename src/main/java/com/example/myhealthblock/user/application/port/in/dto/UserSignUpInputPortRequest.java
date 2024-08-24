package com.example.myhealthblock.user.application.port.in.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: 컨트롤러 계층에서 서비스 계층으로 데이터를 전달하는 DTO 클래스 </b>
 * <br>- 사용자 회원 가입 시 필요한 정보
 */
@Getter
@Setter
public class UserSignUpInputPortRequest {
    private String id;
    private String pw;
    private String role;
}
