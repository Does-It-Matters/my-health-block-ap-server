package com.example.myhealthblock.question.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <b>역할: 게시판의 카테고리를 정의하는 열거형</b>
 * <p>
 * - 질문 등록 시 선택할 게시판을 정의함 <br>
 * - {@code text} 필드를 통해 한국어 명칭에 접근 가능 <br>
 * </p>
 */
@Getter
@RequiredArgsConstructor
public enum Category {
    ENTIRE("전체 게시판"),
    MATERNITY("임산부 게시판"),
    ELDERS("노약자 게시판");

    /** 게시판의 한국어 명칭 */
    private final String text;
}
