package com.example.myhealthblock.question.adapter.in.web.response;

import com.example.myhealthblock.question.domain.dto.QuestionTitleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 질문 제목 목록 조회 응답 클래스 </b>
 * <p>
 * - HTTP 응답 바디에 매핑되는 클래스
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
public class QuestionListResponse {
    private QuestionTitleDTO[] list;

    public QuestionListResponse(QuestionTitleDTO[] list) {
        this.list = list;
    }
}
