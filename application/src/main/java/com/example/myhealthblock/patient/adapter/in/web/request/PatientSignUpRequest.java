package com.example.myhealthblock.patient.adapter.in.web.request;

import com.example.myhealthblock.patient.application.port.in.dto.PatientSignUpInputPortRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientSignUpRequest {
    String id;
    String pw;
    String role;

    /**
     * <b> 역할: 도메인 계층으로 전달하기 위해 입력 포트에서 전달되는 DTO를 매핑하는 메소드 </b>
     * @return 입력 포트에서 전달되는 DTO
     */
    public PatientSignUpInputPortRequest toInputPortDTO() {
        return new PatientSignUpInputPortRequest(id, pw, role);
    }
}
