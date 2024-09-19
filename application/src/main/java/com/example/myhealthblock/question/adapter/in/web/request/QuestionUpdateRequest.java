package com.example.myhealthblock.question.adapter.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 질문 수정 요청 바디 클래스 </b>
 * <p>
 * - HTTP 요청 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionUpdateRequest {
    private Integer questionId;
    private String title;
    private String symptom;
    private String content;
}
