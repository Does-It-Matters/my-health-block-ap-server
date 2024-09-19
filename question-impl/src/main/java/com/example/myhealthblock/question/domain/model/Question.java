package com.example.myhealthblock.question.domain.model;

import com.example.myhealthblock.question.common.BodyPart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <b> 역할: Question 도메인 모델 클래스 </b>
 */
@Getter
@Setter
public class Question {
    Integer id;
    int uid;
    String title;
    String symptom;
    String content;
    List<BodyPart> bodyParts;
    PersonalData personalData;
}
