package com.example.myhealthblock.user.adapter.in.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 비밀번호 수정 응답 클래스 </b>
 * <p>
 * - HTTP 응답 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatePwResponse {
    private String result;
}
