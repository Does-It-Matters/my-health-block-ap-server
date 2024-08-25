package com.example.myhealthblock.question.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

    private final String text;
}