package com.example.myhealthblock.question.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>역할: 질문 제목과 Id를 전달하는 DTO 클래스</b>
 * <p>
 * - 질문의 Id와 제목을 포함하며, 다양한 계층 간 데이터 전송에 사용됨 <br>
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionTitleDTO {
    private String questionId;
    private String title;
}
