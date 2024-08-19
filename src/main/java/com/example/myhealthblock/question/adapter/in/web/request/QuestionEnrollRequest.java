package com.example.myhealthblock.question.adapter.in.web.request;

import com.example.myhealthblock.question.adapter.out.persistence.bodypart.BodyPart;
import com.example.myhealthblock.question.common.Category;
import com.example.myhealthblock.question.domain.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEnrollRequest {
    String userId;
    List<BodyPart> bodyParts;
    Category category;
    String title;
    String symptom;
    String content;
    PersonalDataDTO personalData;
}
