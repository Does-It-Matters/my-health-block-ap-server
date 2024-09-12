package com.example.myhealthblock.question.adapter.in.web.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 요청에 대한 결과 응답 클래스 </b>
 * <p>
 * - HTTP 응답 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
public class ResultResponse {
    private String result;

    public ResultResponse(String result) {
        this.result = result;
    }
}
