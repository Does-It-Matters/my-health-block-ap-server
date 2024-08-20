package com.example.myhealthblock.doctor.application.port.in.dto;

import com.example.myhealthblock.doctor.adapter.in.web.request.DoctorSignUpRequest;
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
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSignUpDTO {
    String id;
    String pw;
    String role;
    String name;
    String field;
    String hospital;
    String introduction;

    public static DoctorSignUpDTO from(DoctorSignUpRequest body) {
        return new DoctorSignUpDTO(
                body.getId(),
                body.getPw(),
                body.getRole(),
                body.getName(),
                body.getField(),
                body.getHospital(),
                body.getIntroduction()
        );
    }
}
