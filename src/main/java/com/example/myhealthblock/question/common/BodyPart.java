package com.example.myhealthblock.question.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <b>역할: 신체 부위를 정의하는 열거형</b>
 * <p>
 * - 질문에서 사용되는 신체 부위를 정의함 <br>
 * - {@code text} 필드를 통해 한국어 명칭에 접근 가능 <br>
 * </p>
 */
@Getter
@RequiredArgsConstructor
public enum BodyPart {
    HAND("손"),
    WRIST("손목"),
    FOOT("발"),
    ANKLE("발목"),
    NECK("목"),
    THROAT("목구멍"),
    HEAD("머리"),
    ARM("팔"),
    HEART("심장"),
    WAIST("허리"),
    EYE("눈"),
    TEETH("이"),
    KNEE("무릎"),
    EAR("귀"),
    SKIN("피부"),
    STOMACH("복부"),
    THIGH("허벅지"),
    CALF("종아리"),
    BACK("등");

    /** 신체 부위의 한국어 명칭 */
    private final String text;
}