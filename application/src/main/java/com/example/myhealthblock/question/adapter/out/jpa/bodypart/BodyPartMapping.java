package com.example.myhealthblock.question.adapter.out.jpa.bodypart;

import com.example.myhealthblock.question.adapter.out.jpa.question.QuestionEntity;
import com.example.myhealthblock.question.common.BodyPart;
import lombok.Getter;
import lombok.Setter;

/**
 * 역할: 질문과 신체 부위의 매핑을 나타내는 클래스 <br>
 *
 * - {@link QuestionEntity}와 {@link BodyPart}의 관계를 표현
 */
@Getter
@Setter
public class BodyPartMapping {
    QuestionEntity question;
    BodyPart bodyPart;
}
