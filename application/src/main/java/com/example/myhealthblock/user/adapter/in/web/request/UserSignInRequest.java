package com.example.myhealthblock.user.adapter.in.web.request;

import com.example.myhealthblock.user.application.port.in.dto.UserSignInInputPortRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 로그인 요청 바디 클래스 </b>
 * <p>
 * - HTTP 요청 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignInRequest {
    private String id;
    private String pw;

    /**
     * <b> 역할: HTTP 요청의 바디 정보를 입력 포트에서 전달되는 DTO로 매핑하는 메소드 </b>
     * @return 입력 포트에서 전달되는 DTO
     */
    public UserSignInInputPortRequest toInputPortDTO() {
        return new UserSignInInputPortRequest(
                id,
                pw
        );
    }
}
