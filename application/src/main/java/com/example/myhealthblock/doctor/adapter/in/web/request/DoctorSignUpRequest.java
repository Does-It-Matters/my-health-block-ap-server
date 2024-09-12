package com.example.myhealthblock.doctor.adapter.in.web.request;

import com.example.myhealthblock.doctor.application.port.in.dto.DoctorSignUpInputPortRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: 의료진 회원가입 HTTP 요청 바디 정보 클래스 </b>
 * <br>- 의료진 회원가입 시 필요한 정보
 */
@Getter
@Setter
public class DoctorSignUpRequest {
    String id;
    String pw;
    String role;
    String name;
    String field;
    String hospital;
    String introduction;

    /**
     * <b> 역할: 도메인 계층으로 전달하기 위해 입력 포트에서 전달되는 DTO를 매핑하는 메소드 </b>
     * @return 입력 포트에서 전달되는 DTO
     */
    public DoctorSignUpInputPortRequest toInputPortDTO() {
        return new DoctorSignUpInputPortRequest(
                id,
                pw,
                role,
                name,
                field,
                hospital,
                introduction
        );
    }
}
