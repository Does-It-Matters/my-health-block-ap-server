package com.example.myhealthblock.user.adapter.in.web.request;

import com.example.myhealthblock.user.application.port.in.dto.UserSignInInportRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRequest {
    private String id;
    private String pw;

    /**
     * <b> 역할: 도메인 계층으로 전달하기 위해 입력 포트에서 전달되는 DTO를 매핑하는 메소드 </b>
     * @return 입력 포트에서 전달되는 DTO
     */
    public UserSignInInportRequest toInportDTO() {
        return new UserSignInInportRequest(
                id,
                pw
        );
    }
}
