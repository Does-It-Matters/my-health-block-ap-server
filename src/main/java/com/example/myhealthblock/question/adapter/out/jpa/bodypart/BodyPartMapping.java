package com.example.myhealthblock.question.adapter.out.jpa.bodypart;

import com.example.myhealthblock.question.adapter.out.jpa.question.QuestionEntity;
import com.example.myhealthblock.question.common.BodyPart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyPartMapping {
    QuestionEntity question;
    BodyPart bodyPart;
}
