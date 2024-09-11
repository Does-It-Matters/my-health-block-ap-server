package com.example.myhealthblock.question.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <b>역할: 성별을 정의하는 열거형</b>
 * <p>
 * - 질문에서 사용되는 사용자의 성별을 정의함 <br>
 * - {@code text} 필드를 통해 한국어 명칭에 접근 가능 <br>
 * </p>
 */
@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("남성"),
    FEMALE("여성"),
    OTHER("기타");

    /** 성별의 한국어 명칭 */
    private final String text;
}
