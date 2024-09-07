package com.example.myhealthblock.question.domain.dto;

import com.example.myhealthblock.question.common.BodyPart;
import com.example.myhealthblock.question.common.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {
    String id;
    int uid;
    String title;
    Category category;
    String symptom;
    String content;
    List<BodyPart> bodyParts;
    PersonalDataDTO personalData;
}
