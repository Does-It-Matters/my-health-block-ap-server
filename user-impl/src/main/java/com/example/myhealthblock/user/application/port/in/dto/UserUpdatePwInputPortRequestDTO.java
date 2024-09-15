package com.example.myhealthblock.user.application.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 컨트롤러 계층에서 서비스 계층으로 데이터를 전달하는 DTO 클래스 </b>
 * <br>- 사용자 비밀번호 변경 시 필요한 정보
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatePwInputPortRequestDTO implements UserUpdatePwInputPortRequest {
    private String oldPw;
    private String newPw;
}