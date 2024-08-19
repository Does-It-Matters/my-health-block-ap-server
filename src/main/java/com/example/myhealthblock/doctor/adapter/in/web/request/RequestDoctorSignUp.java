package com.example.myhealthblock.doctor.adapter.in.web.request;

import lombok.Getter;
import lombok.Setter;

/**
 * <b> 역할: 의료진 회원가입 요청 바디 정보 클래스 </b>
 * <br>- 의료진 회원가입 시 필요한 정보
 */
@Getter
@Setter
public class RequestDoctorSignUp {
    String id;
    String pw;
    String role;
    String name;
    String field;
    String hospital;
    String introduction;
}