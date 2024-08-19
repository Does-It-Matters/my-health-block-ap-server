package com.example.myhealthblock.doctor.adapter.in.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 요청 처리 결과 정보 클래스 </b>
 * <br>- 성공 여부 및 메시지 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseResult {
    private String result;

    public ResponseResult(String result) {
        this.result = result;
    }
}
