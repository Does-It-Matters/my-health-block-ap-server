package com.example.myhealthblock.doctor.adapter.in.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 의료진 프로필 조회에 대한 응답 정보 클래스 </b>
 * <br>- 의료진 프로필 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseDoctorData {
    private String name;
    private String field;
    private String hospital;
    private String introduction;

    public ResponseDoctorData(String name, String field, String hospital, String introduction) {
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
    }
}
