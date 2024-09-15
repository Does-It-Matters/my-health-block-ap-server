package com.example.myhealthblock.question.adapter.in.web.response;

import com.example.myhealthblock.question.domain.dto.QuestionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 질문 조회 응답 클래스 </b>
 * <p>
 * - HTTP 응답 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private QuestionDTO question;
}