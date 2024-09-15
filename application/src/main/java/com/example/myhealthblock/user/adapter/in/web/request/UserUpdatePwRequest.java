package com.example.myhealthblock.user.adapter.in.web.request;

import com.example.myhealthblock.user.application.port.in.dto.UserUpdatePwInputPortRequest;
import com.example.myhealthblock.user.application.port.in.dto.UserUpdatePwInputPortRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 비밀번호 수정 요청 바디 클래스 </b>
 * <p>
 * - HTTP 요청 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePwRequest {
    private String oldPw;
    private String newPw;

    /**
     * <b> 역할: HTTP 요청의 바디 정보를 입력 포트에서 전달되는 DTO로 매핑하는 메소드 </b>
     * @return 입력 포트에서 전달되는 DTO
     */
    public UserUpdatePwInputPortRequest toInputPortDTO() {
        return new UserUpdatePwInputPortRequestDTO(
                oldPw,
                newPw
        );
    }
}
